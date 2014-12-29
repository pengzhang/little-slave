package com.ctb.entity.user;

import java.util.Date;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
public class UserLog extends IdEntity {

	private String username;
	private String loginIp;
	private Date loginDate;
	private String brower;
	private String system;
	
	public UserLog(String username, String loginIp, Date loginDate, String brower, String system) {
		this.username = username;
		this.loginIp = loginIp;
		this.loginDate = loginDate;
		this.brower = brower;
		this.system = system;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getBrower() {
		return brower;
	}
	public void setBrower(String brower) {
		this.brower = brower;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
