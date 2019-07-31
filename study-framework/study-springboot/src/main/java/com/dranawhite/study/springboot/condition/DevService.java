package com.dranawhite.study.springboot.condition;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dranawhite
 * @version : DevService.java, v 0.1 2019-07-30 14:00 dranawhite Exp $$
 */
@Slf4j
public class DevService implements IConditionService {

    @Override
    public void printEnvironment() {
        log.info("Dev Environment!");
    }
}
