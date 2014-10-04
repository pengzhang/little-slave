package com.ctb.entity.disease;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;
/**
 * 疾病预防详细信息
 * @author zhangpeng
 *
 */
@Entity
@Table(name="disease_prevention_detail_info")
public class DiseasePreventionDetailInfo extends IdEntity {
	
	/**
	 * 大部位名称
	 */
	private String bodyPartType;
	/**
	 * 疾病名称
	 */
	private String disease;
	/**
	 * 所属科室
	 */
	private String department;
	/**
	 * 症状体征
	 */
	private String symptoms;
	/**
	 * 疾病预防详细信息
	 */
	@Lob
	@Basic(fetch = FetchType.EAGER)
	private String disease_prevention_detail;
	
	public String getBodyPartType() {
		return bodyPartType;
	}

	public void setBodyPartType(String bodyPartType) {
		this.bodyPartType = bodyPartType;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDisease_prevention_detail() {
		return disease_prevention_detail;
	}

	public void setDisease_prevention_detail(String disease_prevention_detail) {
		this.disease_prevention_detail = disease_prevention_detail;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}