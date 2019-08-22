package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.aop.IPerson;
import com.dranawhite.study.springboot.aop.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : AopController.java, v 0.1 2019-08-22 10:38 dranawhite Exp $$
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private Manager manager;

    @Autowired
    private IPerson person;

    @GetMapping("/declareParents")
    public DranaResponse<Boolean> declareParents() {
        IPerson person = (IPerson) manager;
        person.say();
        manager.sayAgain();
        return DranaResponse.success(Boolean.TRUE);
    }

    @GetMapping("/around")
    public DranaResponse<Boolean> around() {
        person.say();
        return DranaResponse.success(Boolean.TRUE);
    }
}
