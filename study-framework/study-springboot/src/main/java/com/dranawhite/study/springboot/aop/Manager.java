package com.dranawhite.study.springboot.aop;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

/**
 * @author dranawhite
 * @version : Manager.java, v 0.1 2019-08-22 10:31 dranawhite Exp $$
 */
@Component
@Slf4j
public class Manager {

    public void sayAgain() {
        log.info("那个，我再重复几句!");
    }
}
