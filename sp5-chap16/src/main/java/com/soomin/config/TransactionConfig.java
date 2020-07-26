package com.soomin.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.soomin.service" })
public class TransactionConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/spring5fs?serverTimezone=UTC&useSSL=false&characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxTotal(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60 * 1000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}

	@Bean
	Log4JdbcCustomFormatter logFomatter() {
		Log4JdbcCustomFormatter logFomatter = new Log4JdbcCustomFormatter();
		logFomatter.setLoggingType(LoggingType.MULTI_LINE);
		logFomatter.setSqlPrefix("SQL         :    ");
		return logFomatter;
	}

	@Bean
	public Log4jdbcProxyDataSource Log4DataSource() {
		Log4jdbcProxyDataSource ld = new Log4jdbcProxyDataSource(dataSource());
		ld.setLogFormatter(logFomatter());
		return ld;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
}
