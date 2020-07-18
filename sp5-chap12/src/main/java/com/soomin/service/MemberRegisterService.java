package com.soomin.service;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soomin.dao.MemberDAO;
import com.soomin.vo.MemberVO;

@Service
public class MemberRegisterService {
	@Autowired
	private MemberDAO memberDao;

	public MemberRegisterService() {
	}

	public MemberRegisterService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional(rollbackFor = { SQLException.class })
	public Long regist(RegisterRequest req) {
		MemberVO member = memberDao.findMember(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("중복된 이메일" + req.getEmail());
		}

		MemberVO newMember = new MemberVO();
//		req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()
		newMember.setEmail(req.getEmail());
		newMember.setPassword(req.getPassword());
		newMember.setName(req.getName());
		newMember.setRegdate(LocalDateTime.now());

		memberDao.insertMember(newMember);
		return newMember.getId();
	}
}
