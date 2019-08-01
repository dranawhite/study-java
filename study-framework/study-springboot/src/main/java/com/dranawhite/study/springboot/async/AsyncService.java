package com.dranawhite.study.springboot.async;

import com.dranawhite.common.common.ThreadUnit;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

/**
 * @author dranawhite
 * @version : AsyncService.java, v 0.1 2019-07-30 14:50 dranawhite Exp $$
 */
@Async
@Service
@Slf4j
public class AsyncService {

    public void execLongCostTask() {
        log.info("异步任务——Start!");
        ThreadUnit.sleep(10);
        log.info("异步任务——End!");
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 2000)
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
}
