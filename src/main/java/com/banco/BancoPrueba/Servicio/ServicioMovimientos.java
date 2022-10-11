/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.banco.BancoPrueba.Servicio;

import com.banco.BancoPrueba.Entidades.Cliente;
import com.banco.BancoPrueba.Entidades.Movimientos;
import com.banco.BancoPrueba.Repository.CuentaRepository;
import com.banco.BancoPrueba.Repository.MovimientosRepository;
import com.banco.BancoPrueba.Repository.PersonaRepository;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioMovimientos {

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public String realizarMovimiento(String tipoMovimiento, double valor, String numeroCuenta) {
        String respuesta = "";

        try {

            switch (tipoMovimiento) {
                case "DEPOSITO":
                    respuesta = crearDeposito(valor, numeroCuenta);
                    break;
                case "RETIRO":
                    respuesta = crearRetiro(valor, numeroCuenta);
                    break;
            }

            return respuesta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Transactional
    public String crearDeposito(double valor, String numeroCuenta) {
        String respuesta = "";
        Movimientos movimientos = new Movimientos();
        Date fechaMovimiento = new Date();

        try {
            var cuenta = cuentaRepository.obtenerCuenta(numeroCuenta);

            var cuentaAfectar = movimientosRepository.obtenerCuentaAfectar(cuenta.getCuentaId());
            var saldo = movimientosRepository.obtenerSaldo(cuentaAfectar.getCuentaId().getCuentaId());
            var acreditacion = valor + saldo;

            movimientos.setFechaMovimiento(fechaMovimiento);
            movimientos.setCuentaId(cuenta);
            movimientos.setSaldo(new BigDecimal(acreditacion));
            movimientos.setTipoMovimiento("Deposito");
            movimientos.setValor(new BigDecimal(valor));

            movimientosRepository.save(movimientos);

            respuesta = "OK";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Transactional
    public String crearRetiro(double valor, String numeroCuenta) throws ParseException {
        String respuesta = "";
        Movimientos movimientos = new Movimientos();
        Date fechaMovimiento = new Date();

        try {
            var cuenta = cuentaRepository.obtenerCuenta(numeroCuenta);

            var cuentaAfectar = movimientosRepository.obtenerCuentaAfectar(cuenta.getCuentaId());
            var saldo = movimientosRepository.obtenerSaldo(cuentaAfectar.getCuentaId().getCuentaId());
            var valorTope = movimientosRepository.obtenerValorTope(cuentaAfectar.getCuentaId().getCuentaId());
            var acreditacion = saldo - valor;
            var valorVerificacion = valorTope == null ? 0:valorTope + valor;
            
           

            if (valorVerificacion > 1000) {
                return "-2";
            } else {
                if (acreditacion < 0) {
                    return "-1";
                }

                movimientos.setFechaMovimiento(fechaMovimiento);
                movimientos.setCuentaId(cuenta);
                movimientos.setSaldo(new BigDecimal(acreditacion));
                movimientos.setTipoMovimiento("Retiro");
                movimientos.setValor(new BigDecimal(valor));

                movimientosRepository.save(movimientos);
            }

            respuesta = "OK";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

}
