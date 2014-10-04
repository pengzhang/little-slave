package com.ctb.entity.disease;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;
/**
 * 疾病概况信息
 * @author zhangpeng
 *
 */
@Entity
@Table(name="disease")
public class DiseaseInfo extends IdEntity {
	
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
	 * 疾病概述
	 */
	private String disease_description;
	/**
	 * 临床表现
	 */
	private String clinical_feature;
	/**
	 * 疾病预防
	 */
	private String disease_prevention;
	
	public String getDisease_description() {
		return disease_description;
	}
	
	public void setDisease_description(String disease_description) {
		this.disease_description = disease_description;
	}
	
	public String getClinical_feature() {
		return clinical_feature;
	}
	
	public void setClinical_feature(String clinical_feature) {
		this.clinical_feature = clinical_feature;
	}
	
	public String getDisease_prevention() {
		return disease_prevention;
	}
	
	public void setDisease_prevention(String disease_prevention) {
		this.disease_prevention = disease_prevention;
	}
	
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}