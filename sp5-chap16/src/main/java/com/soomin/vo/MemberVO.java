package com.soomin.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soomin.service.WrongPasswordException;

public class MemberVO {
	private Long id;
	private String email;

//	@JsonIgnore 을 VO 클래스의 필드에 붙이면 JSON 응답시 응답정보에서 제외한다.!
	@JsonIgnore
	private String password;
	private String name;

//	@JsonFormat 을 VO 클래스에 필드에 붙이면 JSON 응답시 배열로 생성되는 날짜 값을 ISO-8601 형식으로 변환해서 전송해준다.
//	@JsonFormat(shape = Shape.STRING)
//	@JsonFormat(pattern = "yyyy년 MM월 dd일 a HH시 mm분 ss초")
	private LocalDateTime regdate;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) {
			throw new WrongPasswordException();
		}
		this.password = newPassword;
	}

}
