package com.study.tomcat.digester;

import com.dranawhite.common.resource.ResourceLoader;

import org.apache.commons.digester.Digester;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

/**
 * @author dranawhite
 * @version $Id: DigesterTest.java, v 0.1 2019-03-09 15:15 dranawhite Exp $$
 */
public class DigesterTest {

    private static String path;

    @BeforeClass
    public static void setUp() {
        path = ResourceLoader.getClasspathResource("digester");
    }

    /**
     * 输出结果 Creating Employee! Setting FirstName: Brain Setting LastName : May My Name is Brain	May First Name: Brain
     * Last  Name: May
     */
    @Test
    public void testCommon() {
        File configFile = new File(path, "employee.xml");
        Digester digester = new Digester();

        // Add Rules
        // 创建对象
        digester.addObjectCreate("employee", "com.study.tomcat.digester.Employee");
        // 设置属性
        digester.addSetProperties("employee");
        // 方法调用
        digester.addCallMethod("employee", "printName");

        try {
            Employee employee = (Employee) digester.parse(configFile);
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Last  Name: " + employee.getLastName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testHierarchy() {
        File configFile = new File(path, "employee.xml");
        Digester digester = new Digester();

        digester.addObjectCreate("employee", "com.study.tomcat.digester.Employee");
        digester.addSetProperties("employee");

        digester.addObjectCreate("employee/office", "com.study.tomcat.digester.Office");
        digester.addSetProperties("employee/office");
        digester.addSetNext("employee/office", "addOffice");

        digester.addObjectCreate("employee/office/address", "com.study.tomcat.digester.Address");
        digester.addSetProperties("employee/office/address");
        digester.addSetNext("employee/office/address", "setAddress");

        try {
            Employee employee = (Employee) digester.parse(configFile);
            System.out.println(employee);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testRuleSet() {
        File configFile = new File(path, "employee.xml");
        Digester digester = new Digester();
        digester.addRuleSet(new EmployeeRuleSet());

        try {
            Employee employee = (Employee) digester.parse(configFile);
            System.out.println(employee);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}