package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.strategy.UserServiceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问strategy/print?typeEnum=ADMIN
 * <pre>
 *     枚举大小写敏感
 * </pre>
 *
 * @author dranawhite
 * @version : StrategyController.java, v 0.1 2019-07-29 18:43 dranawhite Exp $$
 */
@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    private UserServiceContext userServiceContext;

    @GetMapping("/print")
    public DranaResponse<String> printService(@RequestParam RoleTypeEnum typeEnum) {
        String userName = userServiceContext.printRoleName(typeEnum);
        return DranaResponse.success(userName);
    }
}
