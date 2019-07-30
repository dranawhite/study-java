package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.async.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dranawhite
 * @version : AsyncController.java, v 0.1 2019-07-30 18:24 dranawhite Exp $$
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/exec")
    public DranaResponse<Boolean> execAsyncTask() {
        asyncService.execLongCostTask();
        return DranaResponse.success(Boolean.TRUE);
    }
}
