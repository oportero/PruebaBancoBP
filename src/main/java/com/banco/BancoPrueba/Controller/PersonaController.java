package com.banco.BancoPrueba.Controller;

import com.banco.BancoPrueba.Dto.DtoPersona;
import com.banco.BancoPrueba.Entidades.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.banco.BancoPrueba.Dto.DtoRespuesta;
import com.banco.BancoPrueba.Entidades.Cliente;
import com.banco.BancoPrueba.Servicio.ServicioPersona;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class PersonaController {
    
    @Autowired
    private ServicioPersona servicioPersona;

    @PostMapping("/grabarPersona")
    public ResponseEntity<?> guardarPersona(@RequestBody Cliente  cliente) {

        try {
            if (servicioPersona.guardarPersonaCliente(cliente)) {
                return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.CREATED.value(), "Datos Registrados Correctamente"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.BAD_REQUEST.value(), "Error no se pueden grabar datos"), HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<DtoRespuesta>(new DtoRespuesta(HttpStatus.BAD_REQUEST.value(),
                    "Error al grabar datos", e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
    
    
     @GetMapping("/consultarPersonas")
    public ResponseEntity<List<Persona>> obtenerPersona() {
        try {

            return ResponseEntity.ok(servicioPersona.obtenerPersonas());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar datos del ciente", e);

        }
    }
    
    
    @GetMapping("/consultarPersonaDto/{ci}")
    public ResponseEntity<Set<DtoPersona>> obtenerPersonaDto(@PathVariable("ci") String ci) {
        try {

            return ResponseEntity.ok(servicioPersona.obtenerPersonasDto(ci));
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error al consultar datos del ciente", e);

        }
    }

}
