package com.study.jvm.generation;

import org.junit.Test;

import java.util.Date;

/**
 * @author dranawhite 2017/8/24
 * @version 1.0
 */
public class GenerateTest {

    @Test
    public void testBasic() {
        Basic<String> basic = new Basic<>("Generation");
        System.out.println("Msg:" + basic.get());
    }

    @Test
    public void testSub() {
        SubGene<String> subGene = new SubGene<>();
        subGene.set("Sub Generation");
        System.out.println("Msg:" + subGene.get());
    }

    @Test
    public void testInner() {
        Basic<String> basic = new Basic<>("Generation");
        System.out.println("Msg:" + basic.getInner());
    }

    @Test
    public void testInnerII() {
        Basic<String> basic = new Basic<>("Generation");
        System.out.println("Msg:" + basic.getInnerII());
    }

    @Test
    public void testTuple() {
        Tuple<Integer, String, Date> tuple = new Tuple<>(1, "generation", new Date());
        System.out.println("ID: " + tuple.getT());
        System.out.println("Msg: " + tuple.getK());
        System.out.println("Date: " + tuple.getV());
    }

}
