package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.study.springboot.sentinel.SentinelService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sentinel监控
 *
 * @author dranawhite
 * @version : SentinelController.java, v 0.1 2019-08-19 16:08 dranawhite Exp $$
 */
@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelController {

    @Autowired
    private SentinelService sentinelService;


    @GetMapping("/print")
    public DranaResponse<String> printService() {
        String result = sentinelService.sentinelService();
        log.info("Result = [{}]", result);
        return DranaResponse.success(result);
    }
}
