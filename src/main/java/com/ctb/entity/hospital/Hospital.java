package com.ctb.entity.hospital;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
@Table(name="hospital")
public class Hospital extends IdEntity {
	/**
	 * 医院名称
	 */
	private String hospitalName;
	/**
	 * 地址
	 */
	private String addr;
	/**
	 * 电话
	 */
	private String tel;
	/**
	 * 官网
	 */
	private String website;
	/**
	 * 简介
	 */
	private String hospitalDesc;

	@Column(nullable=false)
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="LONGTEXT")
	public String getHospitalDesc() {
		return hospitalDesc;
	}

	public void setHospitalDesc(String hospitalDesc) {
		this.hospitalDesc = hospitalDesc;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
