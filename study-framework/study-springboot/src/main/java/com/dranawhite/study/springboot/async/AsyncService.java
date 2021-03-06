package com.dranawhite.study.springboot.async;

import com.dranawhite.common.common.ThreadUnit;
import com.dranawhite.common.model.DranaResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author dranawhite
 * @version : AsyncService.java, v 0.1 2019-07-30 14:50 dranawhite Exp $$
 */
@Async
@Service
@Slf4j
public class AsyncService {

    public void execLongCostTask() {
        // 方法返回结果可以是Future返回执行的结果值，否则只能为空
        log.info("异步任务——Start!");
        ThreadUnit.sleep(10);
        log.info("异步任务——End!");
    }

    public Future<Boolean> execLongFutureTask() {
        log.info("Future异步任务——Start");
        ThreadUnit.sleep(10);
        log.info("Future异步任务——End");
        return new AsyncResult<>(Boolean.TRUE);
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 600000)
    public void execScheduledTask() {
        log.info("定时任务!");
    }

    public void ssePushData(SseEmitter emitter, List<String> wordList) {
        try {
            for (String word : wordList) {
                emitter.send(word);
                log.info(word);
                ThreadUnit.sleep(5);
            }
            emitter.complete();
        } catch (Exception ex) {
            ex.printStackTrace();
            emitter.completeWithError(ex);
        }
    }

    public void asyncRequest(DeferredResult<DranaResponse<String>> result, int waitSec) {
        ThreadUnit.sleep(waitSec);
        result.setResult(DranaResponse.success("SUCCESS"));
    }
}
