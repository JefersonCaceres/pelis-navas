package com.navas.pelisnavas.config;

import com.navas.pelisnavas.excepciones.GenericExcepcion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.navas.pelisnavas.excepciones.MovieException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler {
    private final HttpServletRequest httpServletRequest;

    public ErrorHandler(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorResponse> handle(Throwable ex) {
        return buildResponseError(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<ApiErrorResponse> buildResponseError(HttpStatus httpStatus, Throwable ex) {
        final ApiErrorResponse apiErrorResponse = new ApiErrorResponse(ex.getMessage());
        return new ResponseEntity<>(apiErrorResponse, httpStatus);
    }

    @ExceptionHandler({
            MovieException.class,
    })
    public ResponseEntity<ApiErrorResponse> handle(GenericExcepcion ex) {
        final ApiErrorResponse apiErrorResponse = new ApiErrorResponse(ex.getMensaje());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private static class ApiErrorResponse {
        @JsonProperty
        private final String mensaje;
        private ApiErrorResponse(String mensaje) {
            this.mensaje = mensaje;
        }
    }


}
