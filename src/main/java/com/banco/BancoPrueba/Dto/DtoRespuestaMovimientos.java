package com.banco.BancoPrueba.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoRespuestaMovimientos {
    
    private String mensaje;

    public DtoRespuestaMovimientos() {
    }
    
    
}
