package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "spring" })
@EnableTransactionManagement
public class MemberConfig {

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		dataSource.setUsername("spring5");
		dataSource.setPassword("spring5");
		dataSource.setInitialSize(2);
		dataSource.setMaxActive(10);
		dataSource.setTestWhileIdle(true);
		dataSource.setMinEvictableIdleTimeMillis(60000 * 3);
		dataSource.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transcationManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
}
