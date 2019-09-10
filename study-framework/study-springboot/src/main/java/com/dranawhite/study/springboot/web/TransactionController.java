package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.transaction.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author dranawhite
 * @version : TransactionController.java, v 0.1 2019-09-10 16:20 dranawhite Exp $$
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;

    @GetMapping("/insert")
    public DranaResponse<Boolean> insertUser() throws IOException {
        userService.insert();
        return DranaResponse.success(Boolean.TRUE);
    }
}
