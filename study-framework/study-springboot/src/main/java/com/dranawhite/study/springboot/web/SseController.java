package com.dranawhite.study.springboot.web;

import com.dranawhite.study.springboot.async.AsyncService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务端推送技术
 * <pre>
 *     客户端与服务端单向链接，非常适合后端数据更新频繁，且实时性要求高，又不需要客户端向服务端通信的场景
 *     需要浏览器支持
 * </pre>
 *
 * @author dranawhite
 * @version : SseController.java, v 0.1 2019-08-01 13:50 dranawhite Exp $$
 */
@RestController
@RequestMapping("/sse")
@Slf4j
public class SseController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/push")
    public SseEmitter pushRealData() {
        SseEmitter emitter = new SseEmitter();
        List<String> wordList = buildWordList();
        asyncService.ssePushData(emitter, wordList);
        return emitter;
    }

    private List<String> buildWordList() {
        List<String> wordList = new ArrayList<>();
        wordList.add("Hello, How are you!");
        wordList.add("I am Fine.");
        wordList.add("Thank you.");
        wordList.add("And you?");
        wordList.add("Me too!");
        return wordList;
    }
}
