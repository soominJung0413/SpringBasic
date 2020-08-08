package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {

	@Bean
	@Scope("prototype")
	public Greeter greeter() {
		Greeter greeter = new Greeter();
		greeter.setFormat("%s 안녕하세요!");
		return greeter;
	}
}
