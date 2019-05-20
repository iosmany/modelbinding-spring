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

    String cleanRoutePath(String uri) {
        if (uri.indexOf("/") >= 0)
            return uri.replace("/", "");
        return uri;
    }

    @ExceptionHandler(value = { BindException.class })
    public ModelAndView validationBindExceptionHandler(BindException ex, Model model, HttpServletRequest request) {
        model.addAttribute("peticion", ex.getBindingResult().getTarget());
        model.addAttribute("errores", ex.getFieldErrors());
        ModelAndView modelAndViewResponse = new ModelAndView(cleanRoutePath(request.getRequestURI()), model.asMap(),
                HttpStatus.OK);
        return modelAndViewResponse;
    }

    @ExceptionHandler(value = { Exception.class })
    public ModelAndView unKnownException(Exception ex, HttpServletRequest request) {
        ModelAndView modelAndViewResponse = new ModelAndView();
        modelAndViewResponse.addObject("exMessage", ex.getMessage());
        modelAndViewResponse.addObject("exStacktrace", ex.getStackTrace());
        modelAndViewResponse.addObject("url", request.getRequestURL());
        modelAndViewResponse.addObject("absolute", cleanRoutePath(request.getRequestURI()));
        modelAndViewResponse.setViewName("error");
        return modelAndViewResponse;
    }
}