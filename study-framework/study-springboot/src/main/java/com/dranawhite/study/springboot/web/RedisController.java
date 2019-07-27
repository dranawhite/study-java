package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaRequest;
import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.model.user.UserVO;
import com.dranawhite.study.springboot.redis.UserRedisDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : RedisController.java, v 0.1 2019-07-27 14:24 dranawhite Exp $$
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private UserRedisDAO userRedisDAO;

    @GetMapping("/user/{userId}")
    public DranaResponse<UserVO> getUser(@PathVariable int userId) {
        UserVO user = userRedisDAO.getUser(userId);
        return DranaResponse.success(user);
    }

    @PostMapping("/user")
    public DranaResponse<Boolean> saveUser(@RequestBody DranaRequest<UserVO> request) {
        userRedisDAO.saveUser(request.getData());
        return DranaResponse.success(Boolean.TRUE);
    }
}
