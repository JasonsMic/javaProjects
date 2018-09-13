package com.example.demo1.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jsonw
 *
 * */
@ControllerAdvice
public class ExceptionHandler {
    public static final String ERROR_VIEW = "error";


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e)throws Exception{
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }
}
