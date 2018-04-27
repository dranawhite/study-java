package com.test.jvm.emumeration;

/**
 * @author dranawhite 2017/10/26
 * @version 1.0
 */
public enum Color {

    RED(11, "红色"),
    BLUE(12, "蓝色"),
    YELLOW(13, "黄色"),
    GREEN(14, "绿色");

    private int id;
    private String desc;

    Color(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int toValue() {
        return this.id;
    }

    public String getDesc() {
        return this.desc;
    }

}
