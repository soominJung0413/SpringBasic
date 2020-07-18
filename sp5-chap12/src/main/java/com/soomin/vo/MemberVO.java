package com.soomin.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.soomin.service.WrongPasswordException;

public class MemberVO {
	private Long id;
	private String email;
	private String password;
	private String name;
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

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) {
			throw new WrongPasswordException();
		}
		this.password = newPassword;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", regdate="
				+ regdate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh:mm:ss")) + "]";
	}

}
