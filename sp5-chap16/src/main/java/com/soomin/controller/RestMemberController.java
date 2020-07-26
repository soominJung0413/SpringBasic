package com.soomin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.soomin.dao.MemberDAO;
import com.soomin.service.MemberRegisterService;
import com.soomin.vo.MemberVO;

@RestController
public class RestMemberController {
	@Autowired
	private MemberDAO memberDao;

	@Autowired
	private MemberRegisterService memberReigeterService;

	@GetMapping("/api/members")
	public List<MemberVO> members() {
		return memberDao.selectMemberList();
	}

	@GetMapping("/api/members/{id}")
	public MemberVO member(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		MemberVO member = memberDao.selectById(id);
		if (member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}

}
