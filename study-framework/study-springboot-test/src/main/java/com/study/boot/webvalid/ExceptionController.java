package com.study.boot.webvalid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author liangyq
 * @version $Id: ExceptionController.java, v 0.1 2018-09-04 12:15 liangyq Exp $$
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public void deal(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        StringBuffer sb = new StringBuffer();
        for (ObjectError objectError : result.getAllErrors()) {
            sb.append(((FieldError) objectError).getField() + " :  ").append(objectError.getDefaultMessage());
        }
        System.out.println(sb.toString());
    }

}