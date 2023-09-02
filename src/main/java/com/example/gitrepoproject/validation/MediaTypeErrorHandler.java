package com.example.gitrepoproject.validation;

import com.example.gitrepoproject.infrastructure.controller.GitController;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Log4j2
@ControllerAdvice(assignableTypes = GitController.class)

public class MediaTypeErrorHandler {

    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public HttpMediaTypeNotAcceptableException handleException(HttpMediaTypeNotAcceptableException exception) {
        log.error("Wrong Media Type!");
        return new HttpMediaTypeNotAcceptableException(exception.getMessage());
    }
}
