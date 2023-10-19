package com.dto;

public class UserDTO {

	private String email;
	private String password;
	private String fullName;
	private String gender;
	private String age;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String email, String password, String fullName, String gender, String age) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", password=" + password + ", fullName=" + fullName + ", gender=" + gender
				+ ", age=" + age + "]";
	}
	
	
}
