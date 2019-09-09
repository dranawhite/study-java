package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.async.AsyncService;
import com.dranawhite.study.springboot.interceptor.CostTime;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author dranawhite
 * @version : AsyncController.java, v 0.1 2019-07-30 18:24 dranawhite Exp $$
 */
@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/exec")
    @CostTime
    public DranaResponse<Boolean> execAsyncTask() {
        asyncService.execLongCostTask();
        log.info("DONE");
        return DranaResponse.success(Boolean.TRUE);
    }

    @GetMapping("/future")
    public DranaResponse<Boolean> execFutureTask() throws ExecutionException, InterruptedException {
        Future<Boolean> result = asyncService.execLongFutureTask();
        log.info("Result [{}]", result.get());
        return DranaResponse.success(Boolean.TRUE);
    }
}
