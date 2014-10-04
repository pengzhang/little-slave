package com.ctb.entity.disease;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

/**
 * 科室治疗疾病信息
 * 
 * @author zhangpeng
 * 
 */
@Entity
@Table(name = "department_disease")
public class DepartmentDisease extends IdEntity {

	/**
	 * 大科室
	 */
	private String departmentType;
	/**
	 * 具体科室名称
	 */
	private String department;
	/**
	 * 科室治疗疾病信息采集网址
	 */
	private String departmentUrl;
	/**
	 * 疾病名称
	 */
	private String disease;
	/**
	 * 疾病详情采集网址
	 */
	private String diseaseUrl;
	/**
	 * 采集网站
	 */
	private String fromSite;

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentUrl() {
		return departmentUrl;
	}

	public void setDepartmentUrl(String departmentUrl) {
		this.departmentUrl = departmentUrl;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getDiseaseUrl() {
		return diseaseUrl;
	}

	public void setDiseaseUrl(String diseaseUrl) {
		this.diseaseUrl = diseaseUrl;
	}

	public String getFromSite() {
		return fromSite;
	}

	public void setFromSite(String fromSite) {
		this.fromSite = fromSite;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}