package org.tukorea.web.domain;

public class StudentVO {
	private String id;
	private String passwd;
	private String username;
	private String snum;
	private String depart;
	private String mobile;
	private String email;
	
	
	@Override
	public String toString() {
		return "id : " + id + System.lineSeparator() + "passwd : " + passwd + System.lineSeparator() + "username : " + username + System.lineSeparator() + "snum : " + snum + System.lineSeparator() + "depart : " + depart + System.lineSeparator() + "mobile : " + mobile + System.lineSeparator() + "email : " + email + System.lineSeparator() + "------------------";
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}