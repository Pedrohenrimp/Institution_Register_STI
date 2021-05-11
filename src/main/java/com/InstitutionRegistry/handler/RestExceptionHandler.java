package com.InstitutionRegistry.handler;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {PropertyValueException.class})
    protected ModelAndView handleInvalidInput(RuntimeException ex, WebRequest request){
        ModelAndView mv = new ModelAndView("error", HttpStatus.BAD_REQUEST);
        return mv;
    }
}
