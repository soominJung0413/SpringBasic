package com.soomin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomin.dao.MemberDAO;
import com.soomin.vo.MemberVO;

@Service
public class AuthService {

	@Autowired
	private MemberDAO memberDao;

	public AuthInfo authenticate(String email, String password) {
		MemberVO member = memberDao.findMember(email);
		if (member == null) {
			throw new WrongPasswordException();
		}
		if (!member.matchPassword(password)) {
			throw new WrongPasswordException();
		}
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
}
