/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.banco.BancoPrueba.Servicio;

import com.banco.BancoPrueba.Dto.DtoPersona;
import com.banco.BancoPrueba.Entidades.Cliente;
import com.banco.BancoPrueba.Entidades.Persona;
import com.banco.BancoPrueba.Repository.PersonaRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPersona {

    @Autowired
    private PersonaRepository personaRepository;

    public boolean guardarPersonaCliente(Cliente cliente) {
        boolean respuesta = false;

        try {

            personaRepository.save(cliente);
            respuesta = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public List<Persona> obtenerPersonas() {

        try {

            return personaRepository.obtenerPersonas();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Set<DtoPersona> obtenerPersonasDto(String ci) {

        try {

            return personaRepository.obtenerPersonaDto(ci);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
