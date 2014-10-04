package com.ctb.entity.disease;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

/**
 *  医院科室
 * @author zhangpeng
 *
 */
@Entity
@Table(name = "hospital_department")
public class HospitalDepartment extends IdEntity {
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
