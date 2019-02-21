package com.study.boot.webvalid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dranawhite
 * @version $Id: UserController.java, v 0.1 2019-01-29 18:09 dranawhite Exp $$
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping(value = "/validate")
    public void validate(@RequestBody @Validated(value = {InsertGroup.class}) User user) {
        System.out.println(user);
    }

}
