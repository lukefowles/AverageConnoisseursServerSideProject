package com.example.AverageConnoisseurServerSideProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Error that can be used if password authentication is implemented (A stretch goal outside our MVP)
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class AuthenticationFailed extends RuntimeException {

    public AuthenticationFailed(String message) {super(message);}
}
