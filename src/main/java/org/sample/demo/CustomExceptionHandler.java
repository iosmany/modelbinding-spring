package org.sample.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = { BindException.class })
    public ModelAndView validationBindExceptionHandler(BindException ex, Model model, HttpServletRequest req) {
        model.addAttribute("peticion", ex.getBindingResult().getTarget());
        model.addAttribute("errores", ex.getFieldErrors());
        ModelAndView modelAndViewResponse = new ModelAndView("login", model.asMap(), HttpStatus.OK);
        return modelAndViewResponse;
    }

    @ExceptionHandler(value = { Exception.class })
    public String unKnownException(Exception ex) {
        return "Employee Not Found";
    }
}