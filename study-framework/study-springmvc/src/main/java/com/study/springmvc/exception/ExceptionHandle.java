package com.study.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice注解，需要开启mvc扫描
 *
 * @author dranawhite 2017/9/4
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("====Exception Handler!====");
        System.out.println(e.getMessage());
    }

}
