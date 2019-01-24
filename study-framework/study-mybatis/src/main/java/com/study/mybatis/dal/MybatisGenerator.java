package com.study.mybatis.dal;

import com.dranawhite.common.resource.ResourceLoader;
import com.dranawhite.dal.mybatis.DBgenerrator;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/23 17:14]
 */
public class MybatisGenerator {

	public static void main(String[] args) {
		String url = ResourceLoader.getClasspathResource("mybatis/mybatis-generator.xml");
		DBgenerrator.autoDB(url);
	}

}
