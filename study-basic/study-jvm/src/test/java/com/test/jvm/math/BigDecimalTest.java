package com.test.jvm.math;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author dranawhite 2018/1/17
 * @version 1.0
 */
public class BigDecimalTest {

    @Test
    public void testInteger() {
        String value = "5000";
        BigDecimal meMaxLimitValue = new BigDecimal(value);
        int meMaxLimit = meMaxLimitValue.multiply(new BigDecimal(100)).intValue();
        Assert.assertEquals(meMaxLimit, 500000);
    }

    @Test
    public void testDouble() {
        String value = "5000.00";
        BigDecimal meMaxLimitValue = new BigDecimal(value);
        int meMaxLimit = meMaxLimitValue.multiply(new BigDecimal(100)).intValue();
        Assert.assertEquals(meMaxLimit, 500000);
    }

    @Test
    public void testDouble_Down1() {
        String value = "5000.99";
        BigDecimal meMaxLimitValue = new BigDecimal(value);
        int meMaxLimit = meMaxLimitValue.multiply(new BigDecimal(100)).intValue();
        Assert.assertEquals(meMaxLimit, 500099);
    }

    @Test
    public void testDouble_Down2() {
        String value = "5000.999";
        BigDecimal meMaxLimitValue = new BigDecimal(value);
        int meMaxLimit = meMaxLimitValue.multiply(new BigDecimal(100)).intValue();
        Assert.assertEquals(meMaxLimit, 500099);
    }

}
