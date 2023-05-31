package com.example.crud.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppException extends Exception{
    public AppException(String logException) {
        super();
        log.info(String.format("Exception occurred:"  + logException ));
    }
}
