package com.test.jvm.math;

/**
 * @author dranawhite 2017/10/18
 * @version 1.0
 */
public class Number {

    public static void main(String[] args) {
        System.out.println("====整型缓存-128到127的数据====");
        System.out.println("====Integer型缓存-128到127的数据====");
        Integer i1 = 25;
        Integer i2 = Integer.valueOf(25);
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println("45: " + (i1 == i2));
        System.out.println("128: " + (i3 == i4));

        System.out.println("====Long型缓存-128到127的数据");
        Long l1 = 45L;
        Long l2 = Long.valueOf(45L);
        Long l3 = 128L;
        Long l4 = Long.valueOf(128L);
        System.out.println("45: " + (l1 == l2));
        System.out.println("128: " + (l3 == l4));

        System.out.println("====字符型缓存0到127的数据====");
        Character c1 = 'a';
        Character c2 = Character.valueOf('a');
        Character c3 = 128;
        Character c4 = 128;
        System.out.println("a: " + (c1 == c2));
        System.out.println("128: " + (c3 == c4));
    }

}
