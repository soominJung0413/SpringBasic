package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
public class AppCtx1 {

	@Bean
	public MemberDao memberDao() {
		MemberDao memberDao = new MemberDao();
		return memberDao;
	}

	@Bean
	public MemberPrinter memberPrinter() {
		MemberPrinter memberPrinter = new MemberPrinter();
		return memberPrinter;
	}
}
