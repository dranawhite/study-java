package com.study.jvm.string;

/**
 * @author dranawhite 2017/12/27
 * @version 1.0
 */
public class StringBuilderPro {

    /**
     * 更改字符串内部的数据
     * @param sb
     */
    public void setValue(StringBuilder sb) {
        sb.append("value");
    }

    public static void main(String[] args) {
        StringBuilderPro pro = new StringBuilderPro();
        StringBuilder sb = new StringBuilder();
        pro.setValue(sb);
        System.out.println(sb.toString());
    }

}
