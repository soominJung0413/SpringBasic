package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		MemberDao memberDao = new MemberDao();
		return memberDao;
	}

	@Bean
	public MemberRegisterService memberRegisterService() {
		MemberRegisterService memberRegisterSerivce = new MemberRegisterService();
		return memberRegisterSerivce;
	}

	@Bean
	public ChangePasswordService changePasswordService() {
		ChangePasswordService changePasswordService = new ChangePasswordService();
		return changePasswordService;
	}

//	@Bean
//	public MemberPrinter memberPrinter() {
//		MemberPrinter memberPritner = new MemberPrinter();
//		return memberPritner;
//	}

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
	public MemberListPrinter memberListPrinter() {
		MemberListPrinter memberListPrinter = new MemberListPrinter();
		return memberListPrinter;
	}

	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
		memberInfoPrinter.setMemberPrinter(memberPrinter2());
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
