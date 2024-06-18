package com.gokul_auto_tech.backend_gokul_auto_tech.exception;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.ExceptionDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Data
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> HandleExceptionResolver(Exception ex){
        var exceptiondto = ExceptionDTO.builder().errorMessage(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptiondto);
    }
}
