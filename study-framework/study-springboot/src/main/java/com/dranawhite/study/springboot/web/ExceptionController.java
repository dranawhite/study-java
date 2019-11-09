package com.dranawhite.study.springboot.web;

import com.dranawhite.common.exception.DranaAccessException;
import com.dranawhite.common.exception.DranaAuthorizationException;
import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;
import com.dranawhite.common.model.DranaResponse;
import com.dranawhite.common.text.MessageFormatter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * Exception处理
 * <pre>
 *     系统异常体系设计：
 *     1）采用异常+响应码的设计
 *     2）异常的种类设计是为了在统一异常处理的过程中便于根据不同的异常返回不同的响应结果，比如返回不同的Http状态码，打印日志的级别等
 *     3）响应码的种类设计是为了给前端或者用户返回不同的话术
 * </pre>
 *
 * @author dranawhite
 * @version : ExceptionController.java, v 0.1 2019-07-30 9:39 dranawhite Exp $$
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(value = {
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DranaResponse handleRequestValidationException(Exception ex) {
        String objErrorMsg = parseRequestValidationException(ex);
        log.warn("HTTP请求参数错误, Caused By = [{}]", objErrorMsg);
        return DranaResponse.fail(GenericResultCode.REQUEST_INVALID.getCode(), objErrorMsg);
    }

    @ExceptionHandler(value = {
            DranaAuthorizationException.class
    })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public DranaResponse handleUnauthorizedException(DranaAuthorizationException ex) {
        return DranaResponse.fail(ex.getResultCode());
    }

    @ExceptionHandler(value = {
            DranaAccessException.class
    })
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public DranaResponse handleForbiddenException(DranaAccessException ex) {
        return DranaResponse.fail(ex.getResultCode());
    }

    @ExceptionHandler(value = {
            DranaSystemException.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DranaResponse handleBusinessException(DranaSystemException ex) {
        log.warn("业务异常! Caused By = [{}]", ex.getMessage());
        return DranaResponse.fail(ex.getResultCode());
    }

    @ExceptionHandler(value = {
            Exception.class
    })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DranaResponse handleException(Exception ex) {
        log.error("服务器异常! Caused By = [{}]", ex.getMessage(), ex);
        return DranaResponse.fail(GenericResultCode.SYSTEM_ERROR);
    }

    private String parseRequestValidationException(Exception e) {
        String errorTpl = "{}) {};";
        StringBuilder objErrorMsgBuilder = new StringBuilder();
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            BindingResult error = ex.getBindingResult();
            List<ObjectError> objectErrorList = error.getAllErrors();
            for (int index = 0, size = objectErrorList.size(); index < size; index++) {
                objErrorMsgBuilder.append(MessageFormatter.format(errorTpl, index + 1,
                        objectErrorList.get(index).getDefaultMessage()));
            }
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException ex = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> constraintViolationSet = ex.getConstraintViolations();
            int index = 1;
            for (ConstraintViolation constraintViolation : constraintViolationSet) {
                String objErrorMsg = MessageFormatter.format(errorTpl, index++, constraintViolation.getMessage());
                objErrorMsgBuilder.append(objErrorMsg);
            }
        }
        return objErrorMsgBuilder.toString();
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        // ModelAttribute注解在ControllerAdvice中可以定义全局变量
        model.addAttribute("global", "GlobalAttribute");
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}