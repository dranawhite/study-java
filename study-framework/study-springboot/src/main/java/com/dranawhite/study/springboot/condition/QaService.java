package com.dranawhite.study.springboot.condition;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author dranawhite
 * @version : QaService.java, v 0.1 2019-07-30 13:59 dranawhite Exp $$
 */
@Slf4j
public class QaService implements IConditionService {

    @Override
    public void printEnvironment() {
        log.info("QA Environment!");
    }
}
