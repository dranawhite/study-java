package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaRequest;
import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.common.validate.annotation.InsertGroup;
import com.dranawhite.study.springboot.model.user.UserVO;
import com.dranawhite.study.springboot.strategy.IUserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

/**
 * @author dranawhite
 * @version : ValidationController.java, v 0.1 2019-07-31 15:28 dranawhite Exp $$
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Validated
public class ValidationController {

    @Autowired
    @Qualifier(value = "commonUserService")
    private IUserService userService;

    @GetMapping("/{userId}")
    public DranaResponse<Boolean> getUserById(@PathVariable @Positive(message = "UserId必须是正数") int userId) {
        log.info("UserId = [{}]", userId);
        return DranaResponse.success(Boolean.TRUE);
    }

    @PostMapping
    public DranaResponse<Boolean> saveUser(@RequestBody @Validated(value = InsertGroup.class) DranaRequest<UserVO> request) {
        UserVO user = request.getData();
        log.info("UserName = [{}]", user.getName());
        return DranaResponse.success(Boolean.TRUE);
    }

    @PutMapping
    public DranaResponse<Boolean> updateUser(@RequestBody DranaRequest<UserVO> request) {
        UserVO user = request.getData();
        userService.saveUser(user);
        return DranaResponse.success(Boolean.TRUE);
    }
}
