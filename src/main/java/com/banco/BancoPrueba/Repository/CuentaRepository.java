package com.banco.BancoPrueba.Repository;

import com.banco.BancoPrueba.Dto.DtoEstadoCuenta;
import com.banco.BancoPrueba.Entidades.Cuenta;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    @Query(value = "Select Saldo_Inicial from [PruebaBanco].[banco].cuenta where Numero_Cuenta = :numeroCuenta", nativeQuery = true)
    Double obtenerSaldo(@Param("numeroCuenta") String numeroCuenta);

    @Query("Select c from Cuenta c where c.numeroCuenta = :numeroCuenta")
    Cuenta obtenerCuenta(@Param("numeroCuenta") String numeroCuenta);

    @Query(value = "select mo.fechaMovimiento, p.nombre, cu.numeroCuenta, mo.saldo,cu.estado , mo.tipoMovimiento, mo.valor\n"
            + "from [PruebaBanco].[banco].[Cliente]  cli \n"
            + "inner join [PruebaBanco].[banco].Persona p\n"
            + "on p.personaId = cli.personaId\n"
            + "inner join [PruebaBanco].[banco].Cuenta cu\n"
            + "on cu.clienteId = cli.personaId\n"
            + "inner join [PruebaBanco].[banco].Movimientos mo\n"
            + "on mo.cuentaId = cu.cuentaId\n"
            + "where  p.personaId = :clienteId and\n"
            + "fechaMovimiento between :fechaInicio and :fechaFin order by fechaMovimiento asc", nativeQuery = true)
    List<String> obtenerEstadoCuenta(@Param("clienteId") Long clienteId,
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin);

}
