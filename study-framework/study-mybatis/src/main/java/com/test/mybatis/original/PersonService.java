package com.test.mybatis.original;

import com.dranawhite.exception.DranawhiteException;
import com.test.dal.dao.origin.PersonMapper;
import com.test.dal.model.origin.PersonDO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author liangyq
 * @version [1.0, 2018/5/23 17:44]
 */
@Service
public class PersonService {

	@Autowired
	private PersonMapper personMapper;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		ctx.start();

		PersonMapper personMapper = ctx.getBean(PersonMapper.class);
		PersonDO person = new PersonDO();
		person.setName("Tom");
		person.setAge(27);
		person.setAddress("Queue Route");
		personMapper.insertSelective(person);
	}

}
