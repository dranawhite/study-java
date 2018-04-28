package com.test.log.jdk;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * 日志格式
 *
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
class JdkLogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        Date date = new Date();
        String sDate = date.toString();
        return "[" + sDate + "]" + "[" + record.getLevel() + "]"
                + record.getClass() + "\t" + record.getMessage() + "\n";
    }

}
