package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages = { "spring" }, excludeFilters = {})

public class AppCtx {
	
	@Bean
	public MemberDao memberDao() {
	MemberDao memberDao = new MemberDao();
	return memberDao;
	}
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		MemberPrinter memberPritner = new MemberPrinter();
		return memberPritner;
	}

	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
