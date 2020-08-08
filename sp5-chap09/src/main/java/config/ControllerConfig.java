package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

	@Bean
	public HelloController helloCotroller() {
		return new HelloController();
	}
}
