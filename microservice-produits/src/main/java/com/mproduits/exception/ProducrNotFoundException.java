package com.mproduits.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProducrNotFoundException extends RuntimeException{
    public ProducrNotFoundException(String messg)
    {
        super(messg);
    }
}
