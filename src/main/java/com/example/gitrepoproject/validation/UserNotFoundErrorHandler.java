package com.example.gitrepoproject.validation;

import com.example.gitrepoproject.infrastructure.controller.GitController;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(assignableTypes = GitController.class)
@Log4j2
public class UserNotFoundErrorHandler {
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleException(UserNotFoundException exception) {
        log.warn("USER NOT FOUND");
        return new ErrorResponse(exception.getStatusCode(), exception.getMessage());
    }

}
