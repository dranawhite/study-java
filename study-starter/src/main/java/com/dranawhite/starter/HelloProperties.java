package com.dranawhite.starter;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ConfigurationProperties  将application.properties中的属性映射到Model中
 *
 * @author dranawhite
 * @version : HelloProperties.java, v 0.1 2019-08-28 18:59 dranawhite Exp $$
 */
@ConfigurationProperties(prefix = "hello")
@Setter
@Getter
public class HelloProperties {

    private String msg = "World!";

    private boolean show = true;
}
