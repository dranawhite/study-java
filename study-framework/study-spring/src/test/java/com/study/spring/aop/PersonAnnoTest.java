package com.study.spring.aop;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dranawhite 2018/1/17
 */
public class PersonAnnoTest extends BaseTest {

    @Autowired
    private Person person;

    @Test
    public void testAnno() {
        person.sayTag();
    }

}
