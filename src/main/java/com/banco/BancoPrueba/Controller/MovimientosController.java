package com.banco.BancoPrueba.Controller;

import com.banco.BancoPrueba.Dto.DtoRespuesta;
import com.banco.BancoPrueba.Entidades.Cuenta;
import com.banco.BancoPrueba.Entidades.Persona;
import com.banco.BancoPrueba.Servicio.ServicioMovimientos;
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
@RequestMapping("/api/movimientos")
public class MovimientosController {

    @Autowired
    private ServicioMovimientos servicioMovimientos;

    @PostMapping("/ingresarMovimientos/{tipoMovimiento}/{valorMovimiento}/{cuenta}")
    public ResponseEntity<?> realizarMovimiento(@PathVariable("tipoMovimiento") String tipoMovimiento,
            @PathVariable("valorMovimiento") double valorMovimiento,
            @PathVariable("cuenta") String cuenta) {

        try {
            var respuesta = servicioMovimientos.realizarMovimiento(tipoMovimiento.toUpperCase(), valorMovimiento, cuenta);
            if (respuesta.equals("OK")) {
                return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.CREATED.value(), "Transacción registrada Correctamente"), HttpStatus.CREATED);
            } else if (respuesta.equals("-1")) {
                return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.BAD_REQUEST.value(), "No tiene Disponible"), HttpStatus.BAD_REQUEST);
            }
            if (respuesta.equals("-2")) {
                return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.BAD_REQUEST.value(), "Cupo diario para movimientos de cuenta Excedido"), HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.BAD_REQUEST.value(), "Error en la transacción"), HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.BAD_REQUEST.value(),
                    "Error en la transacción", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

   
}
