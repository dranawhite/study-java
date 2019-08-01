package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : ConverterController.java, v 0.1 2019-07-31 18:51 dranawhite Exp $$
 */
@RestController
@RequestMapping("/converter")
public class ConverterController {

    @Autowired
    private UserVO user;

    @GetMapping("/user")
    public DranaResponse<UserVO> getEncryptedUser() {
        user.setPhone("15895886124");
        return DranaResponse.success(user);
    }
}
