package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.MemberNotFoundException;
import spring.WrongPasswordException;

public class MainForCPS {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		try {
			ChangePasswordService cps = ctx.getBean(ChangePasswordService.class);
			cps.changePassword("soomin@naver.com", "9435", "1234");
			System.out.println("암호를 변경했습니다.");
		} catch (MemberNotFoundException e) {
			System.out.println("회원 데이터가 존재하지 않습니다.");
		} catch (WrongPasswordException e1) {
			System.out.println("암호가 올바르지 않습니다.");
		}

		ctx.close();
	}

}
