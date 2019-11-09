package com.dranawhite.study.springboot.web;

import com.dranawhite.common.model.DranaResponse;
import com.dranawhite.study.springboot.model.user.UserVO;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : SecurityController.java, v 0.1 2019-07-27 16:48 dranawhite Exp $$
 */
@RestController
@RequestMapping("/security")
@Slf4j
public class SecurityController {

    @GetMapping("/noLogin")
    public DranaResponse<Boolean> notNeedValidate() {
        return DranaResponse.success(Boolean.TRUE);
    }

    @GetMapping("/login")
    public DranaResponse<Boolean> needValidate(@AuthenticationPrincipal UserVO user) {
        log.info("User = [{}]", user);
        return DranaResponse.success(Boolean.TRUE);
    }

    @GetMapping("/admin")
    public DranaResponse<Boolean> needAdmin() {
        return DranaResponse.success(Boolean.TRUE);
    }
}
