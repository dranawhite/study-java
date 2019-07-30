package com.dranawhite.study.springboot;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dranawhite
 * @version : BaseTest.java, v 0.1 2019-07-26 14:44 dranawhite Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public abstract class BaseTest {
}
