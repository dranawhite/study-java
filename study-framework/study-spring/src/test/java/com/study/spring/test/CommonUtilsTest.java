package com.study.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * JUnit原生单元测试，参数化测试
 * <pre>
 *     参数化测试对于同一个方法输入多种参数进行测试的情况，简化了代码
 * 步骤如下：
 *      1）单元测试类使用org.junit.runners.Parameterized作为测试运行器
 *      2）为单元测试类声明几个变量，分别用于存储期望值和目标值
 *      3）为单元测试类声明一个使用org.junit.runners.Paramterized.Parameters修饰的，返回值为
 *      java.util.Collection的公共静态方法，并在此方法中初始化所有需要测试的参数对
 *      4）为测试类声明一个带有参数的公共构造函数，并在其中为第二个环节中声明的几个变量初始化
 *      5）编写单元测试方法，使用定义的变量进行测试
 * </pre>
 *
 * @author dranawhite 2017/8/18
 * @version 1.0
 */
@RunWith(Parameterized.class)
public class CommonUtilsTest {

    /**
     * 期望值
     */
    private String excepted;

    /**
     * 目标值
     */
    private String target;

    public CommonUtilsTest(String excepted, String target) {
        this.excepted = excepted;
        this.target = target;
    }

    @Parameterized.Parameters
    public static Collection testConditions() {
        return Arrays.asList(new String[][] {
                {"param", "param"},
                {"myParam", "my_param"},
                {"myParam", "My_param"},
                {"myParam", "MY_PARAM"}
        });
    }

    @Test
    public void testTransferStr() {
        assertEquals(excepted, CommonUtils.transferCammel(target));
    }

}
