package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
public class AppCtx2 {

	@Autowired
	MemberDao memberDao;
	@Autowired
	MemberPrinter memberPrinter;

	@Bean
	public MemberRegisterService memberRegisterService() {
		MemberRegisterService memberRegisterService = new MemberRegisterService(memberDao);
		return memberRegisterService;
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService changePasswordService = new ChangePasswordService();
		changePasswordService.setMemberDao(memberDao);
		return changePasswordService;
	}

	@Bean
	public MemberListPrinter memberListPrinter() {
		MemberListPrinter memberListPrinter = new MemberListPrinter(memberDao, memberPrinter);
		return memberListPrinter;
	}

	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		return memberInfoPrinter;
	}

	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
