package com.dranawhite.study.springboot.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dranawhite
 * @version : UserService.java, v 0.1 2019-09-10 16:11 dranawhite Exp $$
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        String sql = "insert into t_user (name, address, phone) values ('jerry', 'queen street', '18976452354')";
        jdbcTemplate.execute(sql);
        if (1 == 1) {
            throw new NullPointerException();
        }
        jdbcTemplate.execute(sql);
    }
}
