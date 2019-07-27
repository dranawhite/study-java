package com.dranawhite.study.springboot.batch;

import com.dranawhite.common.validate.BeanValidator;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

/**
 * 数据校验
 *
 * @author dranawhite
 * @version : CsvItemValidator.java, v 0.1 2019-07-27 18:20 dranawhite Exp $$
 */
public class CsvItemValidator<UserVO> implements Validator<UserVO> {

    @Override
    public void validate(UserVO userVO) throws ValidationException {
        BeanValidator.validate(userVO);
    }

}
