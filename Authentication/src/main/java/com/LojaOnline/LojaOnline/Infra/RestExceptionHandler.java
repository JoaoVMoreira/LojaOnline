package com.LojaOnline.LojaOnline.Infra;

import com.LojaOnline.LojaOnline.DTO.ReturnExceptionMessageDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ReturnExceptionMessageDTO> runtimeException(RuntimeException exception){
        var tratedException = new ReturnExceptionMessageDTO(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tratedException);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404 (EntityNotFoundException exception){
        var tratedException = new ReturnExceptionMessageDTO(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tratedException);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ReturnExceptionMessageDTO> sqlException(SQLException exception){
        var tratedException = new ReturnExceptionMessageDTO(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tratedException);
    }

}
