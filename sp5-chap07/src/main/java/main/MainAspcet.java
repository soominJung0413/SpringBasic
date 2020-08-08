package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap07.Calculator;
import chap07.RecCalculator;
import config.AppCtx;

public class MainAspcet {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		Calculator cal = ctx.getBean("calculator", RecCalculator.class);
		long result = cal.factorial(20);
		System.out.println("cal.factorial(20) = " + result);
		System.out.println(cal.getClass().getName());

		ctx.close();
	}

}
