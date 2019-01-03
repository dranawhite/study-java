package com.study.log.log4j1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 日志的输出级别是由日志记录器的级别和输出源级别共同决定的
 *
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
class Log4j1Logger {

    private static final Logger logger = LogManager.getLogger(Log4j1Logger.class);

    public void info() {
        logger.info("日志-Log4j1");
    }

    public void debug() {
        logger.debug("日志-Log4j1");
    }

    public void warn() {
        logger.warn("日志-Log4j1");
    }
}
