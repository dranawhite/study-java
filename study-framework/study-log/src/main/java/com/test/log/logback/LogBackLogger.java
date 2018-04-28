package com.test.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dranawhite 2017/9/18
 * @version 1.0
 */
public class LogBackLogger {

    private static final Logger logger = LoggerFactory.getLogger(LogBackLogger.class);

    public void info() {
        logger.info("日志-logback");
    }

    public void debug() {
        logger.debug("日志-logback");
    }

    public void warn() {
        logger.warn("日志-logback");
    }

    public void error() {
        logger.error("日志-logback");
    }

}
