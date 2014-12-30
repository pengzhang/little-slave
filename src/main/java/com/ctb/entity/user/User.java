package com.ctb.entity.user;

import java.util.Date;

import javax.persistence.Column;
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
	private long score;
	private boolean status=true;
	private boolean isAdmin=false;
	
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
	@Column(nullable=false)
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
	@Column(nullable=false)
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
	@Column(nullable=false)
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Column(nullable=false)
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
