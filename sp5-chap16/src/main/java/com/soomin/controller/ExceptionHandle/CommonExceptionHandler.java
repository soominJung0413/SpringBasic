package com.soomin.controller.ExceptionHandle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.soomin.controller")
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public void HandleRuntimeException(RuntimeException ex, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) {
		System.out.print("@ControllerAdvice 작동  ");
		ex.printStackTrace();
	}
	// ExceptionHandler 적용 메서드의 리턴타입은 ModelAndView, String(뷰코드), @ResponseBody를 붙인
	// 경우 임의객체, ResponseEntity
}
