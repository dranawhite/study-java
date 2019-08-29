package com.dranawhite.starter;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;

/**
 * @author dranawhite
 * @version : Service.java, v 0.1 2019-08-28 19:03 dranawhite Exp $$
 */
@Getter
@Setter
public class HelloService {

    private String msg;
    private boolean show;

    public String sayHello() {
        return show ? "Hello " + msg : StringUtils.EMPTY;
    }
}
