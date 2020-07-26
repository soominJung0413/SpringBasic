package com.soomin.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.soomin.dao.MemberDAO;
import com.soomin.service.MemberNotFoundException;
import com.soomin.vo.MemberVO;

@Controller
public class MemberDetailController {

	@Autowired
	private MemberDAO memberDao;

	@GetMapping("/members/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		MemberVO member = memberDao.selectById(id);
		if (member == null) {
			/* throw new RuntimeException(); */
			throw new MemberNotFoundException();
		}
		model.addAttribute("member", member);
		return "member/memberDetail";
	}

	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException(TypeMismatchException ex) {
		return "member/invalidId";
	}

	@ExceptionHandler(MemberNotFoundException.class)
	public String handleMemberNotFoundException(MemberNotFoundException ex) {
		return "member/noMember";
	}
}
