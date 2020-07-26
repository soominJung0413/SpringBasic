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
import com.soomin.service.ChangePasswordService;
import com.soomin.service.ChangePwdCommand;
import com.soomin.service.ChangePwdCommandValidator;
import com.soomin.service.WrongPasswordException;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	@Autowired
	private ChangePasswordService changePwdService;

	@GetMapping
	public String form(@ModelAttribute("command") ChangePwdCommand pwdCmd) {
		return "edit/changePwdForm";
	}

	@PostMapping
	public String submit(@Valid @ModelAttribute("command") ChangePwdCommand pwdCmd, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try {
			changePwdService.changePassword(authInfo.getEmail(), pwdCmd.getCurrentPassword(), pwdCmd.getNewPassword());
			return "edit/changePwd";
		} catch (WrongPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ChangePwdCommandValidator());
	}
}
