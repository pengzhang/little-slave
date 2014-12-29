package com.ctb.entity.user;

import java.util.Date;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
public class User extends IdEntity{
	
	private String username;
	private String password;
	private String salt;
	private String email;
	private String mobile;
	private Date birth;
	private Date pregnantBirth;   //怀孕日期
	private Date childBirth;      //宝宝出生日期
	private String nickName;
	private long loginTime;
	private long loginErrorTime;
	private String accessToken;
	private Date registerDate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getPregnantBirth() {
		return pregnantBirth;
	}
	public void setPregnantBirth(Date pregnantBirth) {
		this.pregnantBirth = pregnantBirth;
	}
	public Date getChildBirth() {
		return childBirth;
	}
	public void setChildBirth(Date childBirth) {
		this.childBirth = childBirth;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}
	public long getLoginErrorTime() {
		return loginErrorTime;
	}
	public void setLoginErrorTime(long loginErrorTime) {
		this.loginErrorTime = loginErrorTime;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
