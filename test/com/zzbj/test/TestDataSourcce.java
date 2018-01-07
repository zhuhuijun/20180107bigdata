package com.zzbj.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzbj.model.User;
import com.zzbj.service.UserService;

import antlr.collections.List;

/**
 * 測試数据源
 * 
 * @author zhuhuijun
 *
 */
public class TestDataSourcce {
	@Test
	public void getConn() throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
		DataSource ds = (DataSource) ac.getBean("dataSource");
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}

	@Test
	public void testService() throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
		UserService us = (UserService) ac.getBean("userService");
		for (int i = 0; i < 100; i++) {
			User u = new User();
			u.setName("aca" + i);
			u.setAge(33);
			us.saveEntity(u);
		}

		System.out.println("hello,world!");

	}
	@Test
	public void testService2() throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
		UserService us = (UserService) ac.getBean("userService");
		us.getEntity(1);
		System.out.println("hello,world!");
	}
	@Test
	public void testService3() throws SQLException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean.xml");
		UserService us = (UserService) ac.getBean("userService");
		java.util.List<User> users = us.findAll();
		System.out.println("hello,world!"+users.size());

	}
}
