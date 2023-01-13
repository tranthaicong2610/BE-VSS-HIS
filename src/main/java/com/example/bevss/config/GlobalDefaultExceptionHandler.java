package com.example.bevss.config;

import com.example.bevss.dto.ErrorDTO;
import com.example.bevss.exception.CommonException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.LinkedHashMap;
import java.util.Locale;


@ControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleCommonException(Exception ex) {
        logger.error("-------> Handle Other Common exception.... {0}", ex);
        String message;
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof MultipartException) {
            message = ex.getMessage();
        } else if (ex instanceof AccessDeniedException) {
            message = "Access denied";
            status = HttpStatus.FORBIDDEN;
        } else if (ex instanceof CommonException) {
            CommonException e = (CommonException) ex;
            try {
                message = messageSource.getMessage(e.getCode(), e.getArgs(), Locale.ROOT);
            } catch (Exception exception) {
                if (e.getArgs() != null && e.getArgs().length > 0 && e.getArgs()[0] instanceof String) {
                    message = String.valueOf(e.getArgs()[0]);
                } else {
                    message = e.getCode();
                }
            }
            status = e.getStatus() != null ? e.getStatus() : HttpStatus.BAD_REQUEST;
        } else if (ex.getCause() instanceof  CommonException) {
            CommonException e = (CommonException) ex.getCause();
            try {
                message = messageSource.getMessage(e.getCode(), e.getArgs(), Locale.ROOT);
            } catch (Exception exception) {
                if (e.getArgs() != null && e.getArgs().length > 0 && e.getArgs()[0] instanceof String) {
                    message = String.valueOf(e.getArgs()[0]);
                } else {
                    message = e.getCode();
                }
            }
            status = e.getStatus() != null ? e.getStatus() : HttpStatus.BAD_REQUEST;
        } else {
            message = ex.getMessage();
        }

        return new ResponseEntity<>(new ErrorDTO(message), new HttpHeaders(), status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LinkedHashMap<String, Object> details = new LinkedHashMap<>();
        logger.error("-------> Handle Other Common exception.... ", ex);
        if (ex instanceof BindException) {
            ((BindException) ex).getBindingResult().getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                details.put(fieldName, errorMessage);
            });
        } else if (ex.getCause() instanceof JsonMappingException) {
            JsonMappingException exception = (JsonMappingException) ex.getCause();
            if (exception.getPath() != null && !exception.getPath().isEmpty()) {
                for (JsonMappingException.Reference item : exception.getPath()) {
                    details.put(item.getFieldName(), item.getDescription());
                }
            }
        } else {
            return new ResponseEntity<>(ex.getMessage(), headers, status);
        }
        return new ResponseEntity<>(details, headers, status);
    }
}