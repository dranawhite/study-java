package com.study.spring.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <pre>
 *     Spring Junit测试套件
 * </pre>
 *
 * @author dranawhite 2017/11/7
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test/applicationContext-test.xml"})
public class PersonSpringTest {

    @Autowired
    private Person person;

    @Test
    public void testPerson() {
        Assert.assertNotNull(person);
    }

}
