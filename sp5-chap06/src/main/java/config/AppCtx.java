package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client2;

@Configuration
public class AppCtx {

	@Bean(initMethod = "connect", destroyMethod = "close")
	@Scope("singleton")
	public Client2 client() {
		Client2 client = new Client2();
		client.setHost("host1");
		return client;
	}
}
