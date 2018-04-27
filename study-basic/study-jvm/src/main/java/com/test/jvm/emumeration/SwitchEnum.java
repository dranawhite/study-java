package com.test.jvm.emumeration;

/**
 * JDK1.7 Switch中对枚举的处理
 * <pre>
 *     enum默认是final类，继承自java.commons.Enum，实现了Comparable接口
 *     enum的valueOf方法和values方法是编译器自动添加的
 *     enum用到switch时是用的oridinal()方法，也可以用values()方法获得数组后再遍历
 * </pre>
 *
 * @author dranawhite 2017/10/25
 * @version 1.0
 */
public class SwitchEnum {

    public static void valueOf() {
        System.out.println(Season.valueOf("AUTUMN"));
    }

    public static void swit() {
        switch(Season.AUTUMN) {
            case SPRING:
                System.out.println(Season.SPRING.toString());
                break;
            case SUMMER:
                System.out.println(Season.SUMMER.toString());
                break;
            case AUTUMN:
                System.out.println(Season.AUTUMN.toString());
                break;
            case WINTER:
                System.out.println(Season.WINTER.toString());
                break;
        }
    }

    public static void values() {
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            System.out.println(season);
        }
    }

    public static void oridinal() {
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            System.out.println(season.ordinal());
        }
    }

    public static void switchColor() {
        final int id = 13;
        for (Color clr : Color.values()) {
            if (clr.toValue() == id) {
                System.out.println(clr.getDesc());
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("====Values====");
        SwitchEnum.values();
        System.out.println("====Oridinal====");
        SwitchEnum.oridinal();
        System.out.println("====Switch====");
        SwitchEnum.switchColor();
        System.out.println("====Swit====");
        SwitchEnum.swit();
    }
}
