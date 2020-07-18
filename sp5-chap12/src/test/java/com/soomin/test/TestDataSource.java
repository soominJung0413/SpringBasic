package com.soomin.test;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.soomin.config.ContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ContextConfig.class })
public class TestDataSource {

	@Autowired
	public DataSource dataSource;
	@Autowired
	public SqlSessionFactory sqlSessionFactory;

	@Test
	public void dataSoruceTest() {
		System.out.println("\n DataSource 작동여부 >>>>> " + dataSource + "\n");
	}

	@Test
	public void sqlSessionFactoryTest() {
		System.out.println("\n SqlSessionTemplate 작동여부 >>>>> " + sqlSessionFactory + "\n");
	}

}
