package com.study.spring.core;

import java.sql.SQLException;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/21 11:54]
 */
@ReposrityBusiness(value = "PersonR")
public class PersonReposrity {

	public void printSql() throws SQLException {
		throw new SQLException("SQL异常");
	}

}
