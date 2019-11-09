package com.dranawhite.study.springboot.web;

import com.dranawhite.common.model.DranaResponse;
import com.dranawhite.study.springboot.condition.IConditionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : ConditionController.java, v 0.1 2019-07-30 14:43 dranawhite Exp $$
 */
@RestController
@RequestMapping("/condition")
public class ConditionController {

    @Autowired
    private IConditionService conditionService;

    @GetMapping("/print")
    public DranaResponse<Boolean> printEnvironment() {
        conditionService.printEnvironment();
        return DranaResponse.success(Boolean.TRUE);
    }
}
