package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.security.MethodSecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dranawhite
 * @version : MethodSecurityController.java, v 0.1 2019-08-09 16:26 dranawhite Exp $$
 */
@RestController
@RequestMapping("/method/security")
public class MethodSecurityController {

    @Autowired
    private MethodSecurityService methodSecurityService;

    @GetMapping
    @PreAuthorize("hasRole(T(com.dranawhite.study.springboot.model.user.RoleTypeEnum).ROOT.name()) " +
            "AND hasRole(T(com.dranawhite.study.springboot.model.user.RoleTypeEnum).ADMIN.name())")
    public DranaResponse<Boolean> testPreAuthorize() {
        return DranaResponse.success(Boolean.TRUE);
    }

    @GetMapping("/filter/{filterId}")
    public DranaResponse<List<Integer>> testPostFilter(@PathVariable int filterId) {
        List<Integer> list = methodSecurityService.filterById(filterId);
        return DranaResponse.success(list);
    }

    @PostMapping("/post")
    public DranaResponse<Boolean> testPostAuthorize() {
        return DranaResponse.success(Boolean.TRUE);
    }

    @PostMapping("/service")
    @PreAuthorize("@methodSecurityService.isMethodSecurityService(#isTrue)")
    public DranaResponse<Boolean> testService(@RequestParam boolean isTrue) {
        return DranaResponse.success(Boolean.TRUE);
    }

    @GetMapping("/spel")
    @PreAuthorize("isAdmin()")
    public DranaResponse<Boolean> testSpel() {
        return DranaResponse.success(Boolean.TRUE);
    }
}
