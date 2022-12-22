package com.example.bevss.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class CommonException extends RuntimeException {
    private String code;
    private HttpStatus status;
    private Object[] args;

    public CommonException(String code) {
        this.code = code;
    }

    public CommonException(@Nullable HttpStatus status, String code) {
        this.code = code;
        this.status = status;
    }

    public CommonException(String code, @Nullable String ...args) {
        this.code = code;
        this.args = args;
    }

    public CommonException(@Nullable HttpStatus status, @Nullable String code, @Nullable String ...args) {
        this.code = code;
        this.args = args;
        this.status = status;
    }
}
