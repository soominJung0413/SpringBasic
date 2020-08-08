package spring;

import java.time.LocalDateTime;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime RegisterDateTime;

	public Member(String email, String password, String name, LocalDateTime RegisterDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.RegisterDateTime = RegisterDateTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return RegisterDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) {
			throw new WrongPasswordException();
		}
		this.password = newPassword;
	}
}
