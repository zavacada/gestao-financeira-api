package com.julio.gestao_financeira.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErroCampo> tratarValidacao(MethodArgumentNotValidException ex) {
        return ex.getFieldErrors().stream()
                .map(ErroCampo::new)
                .toList();
    }

    private record ErroCampo(String campo, String mensagem) {
        public ErroCampo(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
