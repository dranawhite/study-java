package com.test.mybatis.original;

import com.dranawhite.exception.DranawhiteException;
import com.test.dal.dao.origin.PersonMapper;
import com.test.dal.model.origin.PersonDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author liangyq
 * @version [1.0, 2018/5/23 17:44]
 */
public class PersonService {

	private SqlSessionFactory getSqlSessionFactory() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-configuration.xml");
			return new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new DranawhiteException(e);
		}
	}

	private SqlSession getSession() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		return sqlSessionFactory.openSession();
	}

	private PersonMapper getPersonMapper() {
		SqlSession session = getSession();
		return session.getMapper(PersonMapper.class);
	}

	public static void main(String[] args) {
		PersonService personService = new PersonService();
		PersonMapper personMapper = personService.getPersonMapper();
		PersonDO person = new PersonDO();
		person.setName("Tom");
		person.setAge(27);
		person.setAddress("Queue Route");
		personMapper.insertSelective(person);
	}

}
