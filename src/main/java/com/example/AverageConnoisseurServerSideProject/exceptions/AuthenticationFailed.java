package com.example.AverageConnoisseurServerSideProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class AuthenticationFailed extends RuntimeException {

    public AuthenticationFailed(String message) {super(message);}
}
