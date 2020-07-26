package com.soomin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soomin.dao.MemberDAO;
import com.soomin.service.ListCommand;
import com.soomin.vo.MemberVO;

@Controller
public class MemberListController {
	@Autowired
	private MemberDAO memberDao;

	@RequestMapping("/members")
	public String list(@ModelAttribute("cmd") ListCommand listCommand, Errors errors, Model model) {

		if (errors.hasErrors()) {
//			Error객체가 있을시에 @DateTimeFormat형식과 맞지 않는 값이 들어왔을경우 반드시 typeMissmatch 메세지를 추가시킨다.
			return "member/memberList";
		}
		if (listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<MemberVO> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}

}
