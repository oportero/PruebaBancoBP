package com.banco.BancoPrueba.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoPersona {

    private Long personaId;
    private String nombre;
    private String identificacion;

    public DtoPersona() {
    }

    public DtoPersona(Long personaId, String nombre, String identificacion) {
        this.personaId = personaId;
        this.nombre = nombre;
        this.identificacion = identificacion;
    }
    
}
