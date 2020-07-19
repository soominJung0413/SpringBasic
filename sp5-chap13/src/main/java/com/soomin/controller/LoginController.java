package com.soomin.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soomin.service.AuthInfo;
import com.soomin.service.AuthService;
import com.soomin.service.LoginCommand;
import com.soomin.service.WrongPasswordException;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AuthService authService;

	@GetMapping
	public String form(@ModelAttribute LoginCommand loginCommand) {
		return "login/loginForm";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute LoginCommand loginCommand, Errors errors, HttpSession httpSession) {
		if (errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());

			// 세션에 authInfo 저장
			httpSession.setAttribute("authInfo", authInfo);

			return "login/loginSuccess";
		} catch (WrongPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
}
