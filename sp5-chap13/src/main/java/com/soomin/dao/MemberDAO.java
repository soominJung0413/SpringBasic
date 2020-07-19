package com.soomin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.soomin.vo.MemberVO;

@Mapper
@Transactional(rollbackFor = { SQLException.class })
public interface MemberDAO {
	List<MemberVO> selectMemberList();

	void insertMember(MemberVO id);

	void deleteMember(String delete);

	MemberVO findMember(String email);

	void updateMember(MemberVO update);

}
