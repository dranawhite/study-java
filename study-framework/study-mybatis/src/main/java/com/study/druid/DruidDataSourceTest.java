/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.druid;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author dranawhite
 * @version $Id: DruidDataSourceTest.java, v 0.1 2019-01-03 14:51 dranawhite Exp $$
 */
public class DruidDataSourceTest {

//    public static void main(String[] args) throws SQLException {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
//        dataSource.setMaxActive(50);
//        dataSource.setInitialSize(10);
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//
//        DruidPooledConnection conn = dataSource.getConnection();
//        String sql = "select user_id, job_number, user_name from user_team";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        rs.next();
//        System.out.println(rs.getObject(1) + ": " + rs.getObject(2) + ": " + rs.getObject(3));
//        conn.close();
//    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        DriverManager.getConnection(url, username, password);
    }
}
