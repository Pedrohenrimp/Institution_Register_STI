package com.InstitutionRegistry.handler;

import com.InstitutionRegistry.error.EmptyFieldException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EmptyFieldException.class})
    protected ModelAndView handleInvalidInput(RuntimeException ex, WebRequest request){
        ModelAndView mv = new ModelAndView("error", HttpStatus.BAD_REQUEST);
        mv.addObject("error", ex);
        return mv;
    }

    @ExceptionHandler(value = Exception.class)
    protected ModelAndView handleException(RuntimeException ex, WebRequest request){
        ModelAndView mv = new ModelAndView("redirect:/institution", HttpStatus.BAD_REQUEST);
        System.out.println(ex);
        return mv;
    }
}
