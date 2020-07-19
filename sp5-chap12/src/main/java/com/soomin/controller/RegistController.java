package com.soomin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soomin.service.DuplicateMemberException;
import com.soomin.service.MemberRegisterService;
import com.soomin.service.RegisterRequest;

@Controller
@RequestMapping("/register")
public class RegistController {

	@Autowired
	private MemberRegisterService memberRegisterSerivce;

	@RequestMapping("/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/step2")
	public String handeStep2(Model model, @RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			@ModelAttribute RegisterRequest regisetRequest) {
		if (!agree) {
			return "register/step1";
		}
		return "register/step2";
	}

	@GetMapping("/step2")
	public String handleStep2Get() {
		return "redirect:step1";
	}

	@PostMapping("/step3")
	public String handleStep3(@Valid @ModelAttribute RegisterRequest regReq, Errors errors) {
		if (errors.hasErrors())
			return "register/step2";
		try {
			memberRegisterSerivce.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}

//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new RegisterRequestValidator());
////	}	binder.addValidators(new RegisterRequestValidator());
//	}

}
