package com.test.mybatis.original;

import com.test.dal.dao.origin.PersonMapper;
import com.test.dal.model.origin.PersonDO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author liangyq
 * @version [1.0, 2018/5/23 17:44]
 */
@Service
public class PersonService {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
		ctx.start();

		PersonMapper personMapper = ctx.getBean(PersonMapper.class);
		System.out.println("第一次查询");
		personMapper.selectByPrimaryKey(1);
		System.out.println("第二次查询");
		personMapper.selectByPrimaryKey(1);
		System.out.println("第三次查询");
		personMapper.selectByPrimaryKey(1);
	}

}
