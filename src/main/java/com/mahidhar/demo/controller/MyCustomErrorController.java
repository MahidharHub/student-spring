package com.mahidhar.demo.controller;

import com.mahidhar.demo.exception.ExceptionResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class MyCustomErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody

    public ResponseEntity<Object> handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");


        ExceptionResponse exceptionResponse  =
                new ExceptionResponse(new Date(), exception.getStackTrace().toString(),request.getMethod() + "  not found");
          return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}