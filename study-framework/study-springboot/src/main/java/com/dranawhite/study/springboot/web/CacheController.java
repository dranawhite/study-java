package com.dranawhite.study.springboot.web;

import com.dranawhite.common.model.DranaRequest;
import com.dranawhite.common.model.DranaResponse;
import com.dranawhite.study.springboot.cache.CacheService;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : CacheController.java, v 0.1 2019-07-27 11:30 dranawhite Exp $$
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/user/{userId}")
    public DranaResponse<UserVO> getUser(@PathVariable int userId) {
        UserVO user = cacheService.getUser(userId);
        return DranaResponse.success(user);
    }

    @PostMapping("/user")
    public DranaResponse<Boolean> saveUser(@RequestBody DranaRequest<UserVO> request) {
        cacheService.saveUser(request.getData());
        return DranaResponse.success(Boolean.TRUE);
    }

    @DeleteMapping("/user/{userId}")
    public DranaResponse<Boolean> deleteUser(@PathVariable int userId) {
        cacheService.removeUser(userId);
        return DranaResponse.success(Boolean.TRUE);
    }
}
