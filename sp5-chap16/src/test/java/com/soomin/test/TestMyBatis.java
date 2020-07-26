package com.soomin.test;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.soomin.config.ContextConfig;
import com.soomin.dao.MemberDAO;
import com.soomin.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ContextConfig.class })
public class TestMyBatis {

	@Autowired
	private MemberDAO memberDao;

	@Test
	public void memberDaoTest() {

		try {
			List<MemberVO> list = memberDao.selectMemberList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void insertMemberTest() {
		MemberVO m = new MemberVO();
		m.setId(3L);
		m.setEmail("madvirus@mad.net");
		m.setPassword("7890");
		m.setName("최범균");
		m.setRegdate(LocalDateTime.now());

		try {
			memberDao.insertMember(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void findMemberTest() {
		try {
			MemberVO member1 = memberDao.findMember("madvirus@mad.net");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void deleteMemberTest() {
		try {
			memberDao.deleteMember("madvirus@mad.net");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
