package com.dranawhite.study.springboot.batch;

import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * @author liangyuquan
 * @version : ExcelWriter.java, v 0.1 2019-07-27 18:44 liangyuquan Exp $$
 */
public class ExcelWriter implements ItemWriter<UserVO> {

    @Override
    public void write(List<? extends UserVO> list) {
        // Do Nothing
    }
}
