package com.banco.BancoPrueba.Controller;

import com.banco.BancoPrueba.Dto.DtoRespuesta;
import com.banco.BancoPrueba.Entidades.Cliente;
import com.banco.BancoPrueba.Entidades.Cuenta;
import com.banco.BancoPrueba.Entidades.Persona;
import com.banco.BancoPrueba.Servicio.ServicioCuenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cuentas")
public class CuentaController {
    
    @Autowired
    private ServicioCuenta servicioCuenta;
    
     @PostMapping("/grabarCuentaCliente")
    public ResponseEntity<?> grabarCuentaCliente(@RequestBody Cuenta  cuenta) {

        try {
            if (servicioCuenta.guardarCuentaCliente(cuenta)) {
                return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.CREATED.value(), "Cuenta registrada Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.BAD_REQUEST.value(), "Error al grabar datos"), HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
   
    
     @GetMapping("/reporte/{cliente}/{fechaInicio}/{fechaFin}")
    public ResponseEntity<?> reporte(@PathVariable("cliente") Long cliente,
            @PathVariable("fechaInicio") String fechaInicio,
            @PathVariable("fechaFin") String fechaFin) {
        try {

            return ResponseEntity.ok(servicioCuenta.reporte(fechaInicio, fechaFin, cliente));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar", e);

        }
    }

    
}
