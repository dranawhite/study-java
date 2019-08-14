package com.dranawhite.study.pattern.prototype;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite
 * @version : Foo.java, v 0.1 2019-08-14 10:35 dranawhite Exp $$
 */
@Setter
@Getter
public class Foo implements Cloneable {

    private int id;
    private String name;
    private String address;
    private String mail;

    private List<String> list;

    private Foo() {
        System.out.println("New Foo!");
    }

    @Override
    public Foo clone() {
        try {
            return (Foo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setId(11);
        foo.setName("Jerry");
        foo.setAddress("green street no 1801");
        foo.setMail("dranawhite@gmail.com");
        List<String> list = new ArrayList<>();
        list.add("tony");
        foo.setList(list);

        // super.clone形式，是在内存中通过二进制流的形式生成的对象，不会调用构造方法，效率更高
        Foo tmp1 = foo.clone();
        list.add("tom");
        System.out.println(tmp1);
        // 结果
        // New Foo! 构造器中的方法只执行一次
        // Foo[id=11,name=Jerry,address=green street no 1801,mail=dranawhite@gmail.com,list=[tony, tom]]

        // 如果要深拷贝则重写clone方法如下
        // public Foo clone() {
        //    Foo tmp = super.clone();
        //    tmp.list = this.list.clone();
        // }

        // final修饰的方法不能被clone
    }
}
