package com.example.gitrepoproject.validation;

import org.springframework.http.HttpStatusCode;


public record ErrorResponse(HttpStatusCode status, String message) {

}
