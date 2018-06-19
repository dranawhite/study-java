package com.test.mybatis.orginal;

import com.test.mybatis.dal.dao.origin.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author liangyq
 * @version [1.0, 2018/5/24 16:53]
 */
public class PersonService {

	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis/mybatis-configuration-orginal.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
		personMapper.selectByPrimaryKey(1);
	}

}
