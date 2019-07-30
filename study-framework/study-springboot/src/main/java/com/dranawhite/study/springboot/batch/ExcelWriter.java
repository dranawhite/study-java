package com.dranawhite.study.springboot.batch;

import java.util.List;

import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.batch.item.ItemWriter;

/**
 * @author dranawhite
 * @version : ExcelWriter.java, v 0.1 2019-07-27 18:44 dranawhite Exp $$
 */
public class ExcelWriter implements ItemWriter<UserVO> {

    @Override
    public void write(List<? extends UserVO> list) {
        // Do Nothing
    }
}
