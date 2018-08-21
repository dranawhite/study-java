package com.study.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author liangyq
 * @version [1.0, 2018/4/21 11:50]
 */
public class BusinessParserPro {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("core/applicationContext-core-scan.xml");
        PersonBusiness personBusiness = (PersonBusiness) ctx.getBean("personB");
        personBusiness.print();

        PersonReposrity personReposrity = (PersonReposrity) ctx.getBean("PersonR");
        personReposrity.printSql();
    }

}
