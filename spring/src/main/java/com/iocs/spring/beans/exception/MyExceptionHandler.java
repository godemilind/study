package com.iocs.spring.beans.exception;

import com.iocs.spring.beans.security.JwtController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler
        //extends ResponseEntityExceptionHandler
        {
    private Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionDetails> handleException(Exception e){
        logger.error(e.getMessage(),e);
        ExceptionDetails ed = new ExceptionDetails(e.getMessage());
        return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseEntity<ExceptionDetails> onConstraintValidationException(
            ConstraintViolationException e) {
        logger.error(e.getMessage(),e);
        ExceptionDetails ed = new ExceptionDetails(e.getMessage());
        return new ResponseEntity<ExceptionDetails>(ed, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(),ex);
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
        //return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }


//            @Override
//            protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//                Map<String, String> errors = new HashMap<>();
//                ex.getBindingResult().getAllErrors().forEach((error) -> {
//                    String fieldName = ((FieldError) error).getField();
//                    String errorMessage = error.getDefaultMessage();
//                    errors.put(fieldName, errorMessage);
//                });
//                return ResponseEntity.badRequest().body(errors);
//                //return super.handleMethodArgumentNotValid(ex, headers, status, request);
//            }
        }
