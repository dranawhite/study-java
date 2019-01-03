package com.study.jvm.emumeration;

/**
 * @author dranawhite 2017/10/25
 * @version 1.0
 */
public enum Season {

    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");

    private String desc;

    Season(String desc) {
        this.desc = desc;
    }
}
