package com.dranawhite.study.springboot.web;

import com.dranawhite.common.common.ThreadUnit;
import com.dranawhite.study.springboot.async.AsyncService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * @author dranawhite
 * @version : AsyncRequestController.java, v 0.1 2019-08-01 16:21 dranawhite Exp $$
 */
@RestController
@RequestMapping("/request/async")
@Slf4j
public class AsyncRequestController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/web")
    public WebAsyncTask<String> webAsyncTask(@RequestParam int waitSec) {
        Callable<String> result = () -> {
            ThreadUnit.sleep(waitSec);
            log.info("WebAsyncTask SUCCESS!");
            return "SUCCESS";
        };
        WebAsyncTask<String> asyncTask = new WebAsyncTask<>(0L, result);
        asyncTask.onTimeout(() -> {
            log.info("WebAsyncTask TIMED OUT!");
            return "TIMED_OUT";
        });
        return asyncTask;
    }

    @GetMapping("/deferred")
    public DeferredResult<String> deferredResult(@RequestParam int waitSec) {
        DeferredResult<String> result = new DeferredResult<>(4000L);
        result.onTimeout(() -> {
            log.info("DeferredResult TIMED OUT!");
            result.setResult("TIMED_OUT");
        });
        result.onCompletion(() -> log.info("DeferredResult SUCCESS"));
        asyncService.asyncRequest(result, waitSec);
        return result;
    }
}
