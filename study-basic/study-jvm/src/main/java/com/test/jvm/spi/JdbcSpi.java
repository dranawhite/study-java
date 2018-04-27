package com.test.jvm.spi;

import java.sql.Driver;
import java.util.ServiceLoader;

/**
 * 使用SPI的方式连接数据库驱动
 *
 * 注：ServiceLoader从JDK1.6才有的
 * <pre>
 * 输出结果：
 *      oracle.jdbc.OracleDriver@26a1ab54
 *      com.mysql.cj.jdbc.Driver@5a10411
 * </pre>
 *
 * @author dranawhite 2017/11/2
 * @version 1.0
 */
public class JdbcSpi {

    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        for (Driver driver : loader) {
            System.out.println(driver.toString());
        }
    }

}
