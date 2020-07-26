package com.soomin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
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
	public String form(@ModelAttribute LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie cookie) {
		if (cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "login/loginForm";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute LoginCommand loginCommand, Errors errors, HttpSession httpSession,
			HttpServletResponse response) {
		if (errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());

			httpSession.setAttribute("authInfo", authInfo);

			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			if (loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}

			response.addCookie(rememberCookie);

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
