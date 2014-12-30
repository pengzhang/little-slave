package com.ctb.entity.user;

import java.util.Date;

import javax.persistence.Column;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

public class AdminUser extends IdEntity{

	private String username;
	private String password;
	private String email;
	private String mobile;
	private String nickName;
	private String loginTime;
	private boolean isAdmin;
	private Date registerDate;
	
	@Column(nullable=false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
