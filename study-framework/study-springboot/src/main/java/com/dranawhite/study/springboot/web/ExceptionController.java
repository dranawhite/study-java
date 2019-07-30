package com.dranawhite.study.springboot.web;

import java.util.List;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.text.MessageFormatter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception处理
 *
 * @author dranawhite
 * @version : ExceptionController.java, v 0.1 2019-07-30 9:39 dranawhite Exp $$
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(
            value = {MethodArgumentNotValidException.class}
    )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DranaResponse argumentInvalid(MethodArgumentNotValidException ex) {
        BindingResult error = ex.getBindingResult();
        List<ObjectError> objectErrorList = error.getAllErrors();
        String errorTpl = "{}) {};";
        StringBuilder objErrorMsgBuilder = new StringBuilder();
        for (int index = 0, size = objectErrorList.size(); index < size; index++) {
            objErrorMsgBuilder.append(MessageFormatter.format(errorTpl, index + 1,
                    objectErrorList.get(index).getDefaultMessage()));
        }
        String objErrorMsg = objErrorMsgBuilder.toString();

        log.warn("HTTP请求参数错误, Caused By = [{}]", objErrorMsg);
        return DranaResponse.fail(ResultCodeEnum.ILLEGAL_REQUEST.getCode(), objErrorMsg);
    }
}
