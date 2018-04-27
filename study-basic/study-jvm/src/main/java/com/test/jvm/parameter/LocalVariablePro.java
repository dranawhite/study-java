package com.test.jvm.parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * JVM属性表中：
 *  LineNumberTable     描述Java源码行号与字节码行号对应关系。默认生成到class文件，使用-g:none和-g:lines取消或生成；
 *                      如果取消，则打印的异常信息中，缺失对应的行号，并且Debug时，无法按照源码设置断点
 *  LocalVariableTable  描述局部变量表中变量与Java源码中变量定义之间的关系。默认不生成到class文件，使用-g:none和-g:vars取消或生成
 *                      如果取消，则参数名称丢失，变成arg0、arg1之类的占位符
 *  LocalVariableTypeTable  描述泛型信息，用-g:none或者-g:vars取消或者生成
 *  SourceFile          记录生成该class的源文件名称，使用-g:none或者-g:sources来取消或者生成（类名与文件名一般一致，内部类除外）
 *                      如果取消，则打印的异常信息中，堆栈中不会显示出错误代码所属的文件名
 * </pre>
 *
 * <pre>
 * 打印结果：
 *      当以参数-g:none编译时，结果如下：
 * Exception in thread "main" java.lang.NullPointerException
 *      at com.dranawhite.jvm.parameter.LocalVariablePro.print(Unknown Source)
 *      at com.dranawhite.jvm.parameter.LocalVariablePro.main(Unknown Source)
 * 行数Unknown Source
 * 设置断点，无法debug
 * </pre>
 *
 * @author dranawhite 2017/12/28
 * @version 1.0
 */
public class LocalVariablePro {

    public void print(List<Person> strList) {
        throw new NullPointerException();
    }

    class Person {
        private int id;
        private String name;
        private int age;

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the age
         */
        public int getAge() {
            return age;
        }

        /**
         * @param age the age to set
         */
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        LocalVariablePro pro = new LocalVariablePro();
        Person person = pro.new Person();
        List<Person> list = new ArrayList<>();
        list.add(person);
        pro.print(list);
    }
}
