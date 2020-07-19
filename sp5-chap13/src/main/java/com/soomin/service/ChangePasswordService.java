package com.soomin.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.soomin.dao.MemberDAO;
import com.soomin.vo.MemberVO;

@Component
public class ChangePasswordService {

	@Autowired
	private MemberDAO memberDao;

	@Transactional(rollbackFor = SQLException.class)
	public void changePassword(String email, String oldPwd, String newPwd) {
		MemberVO member = memberDao.findMember(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);

		memberDao.updateMember(member);
	}

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
}
