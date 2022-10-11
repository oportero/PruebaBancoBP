package com.banco.BancoPrueba.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DtoRespuesta {

    private Long codigoCreacion;
    private Integer codigoRespuesta;
    private String mensaje;
    private String causaExitoError;

    public DtoRespuesta() {
    }

    public DtoRespuesta(Long codigoCreacion, Integer codigoRespuesta, String mensaje, String causaExitoError) {
        this.codigoCreacion = codigoCreacion;
        this.codigoRespuesta = codigoRespuesta;
        this.mensaje = mensaje;
        this.causaExitoError = causaExitoError;
    }

    public DtoRespuesta(Integer codigoRespuesta, String mensaje, String causaExitoError) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensaje = mensaje;
        this.causaExitoError = causaExitoError;
    }

    public DtoRespuesta(Integer codigoRespuesta, String mensaje) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensaje = mensaje;
    }
}
