package com.corenetworks.hotelMascotas.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice

public class ControladorExcepciones extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExcepcionPersonalizadaNoEncontrado.class)
    public ResponseEntity<ExcepcionRespuesta>catchDeNoEncontrado(ExcepcionPersonalizadaNoEncontrado ex, WebRequest peticion) {
//1. Crear un objeto de Excepcion Respuesta
        ExcepcionRespuesta e1=new ExcepcionRespuesta(LocalDateTime.now(),ex.getMessage(),peticion.getDescription(false));
    //2. Devolverla
        return  new ResponseEntity<>(e1, HttpStatus.NOT_FOUND);
    }
    public final ResponseEntity<ExcepcionRespuesta>catchTodasLasExcepciones(Exception ex, WebRequest peticion){
        //1. Crear un objeto de Excepcion Respuesta
        ExcepcionRespuesta e1=new ExcepcionRespuesta(LocalDateTime.now(),ex.getMessage(),peticion.getDescription(false));
        //2. Devolverla
        return  new ResponseEntity<>(e1, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
