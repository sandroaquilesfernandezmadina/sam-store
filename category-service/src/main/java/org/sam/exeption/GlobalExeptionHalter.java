package org.sam.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHalter {
@ExceptionHandler(ResourceNotFountExeption.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFountExeption ex){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}
}
