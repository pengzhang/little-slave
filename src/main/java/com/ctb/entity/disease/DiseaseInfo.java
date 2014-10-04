package com.ctb.entity.disease;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;
/**
 * 疾病概况信息
 * @author zhangpeng
 *
 */
@Entity
@Table(name="disease_info")
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
	/**
	 * 查询类型: 按部位,按科室
	 */
	private String from_type;
	
	
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="longtext")
	public String getDisease_description() {
		return disease_description;
	}
	
	public void setDisease_description(String disease_description) {
		this.disease_description = disease_description;
	}
	
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="longtext")
	public String getClinical_feature() {
		return clinical_feature;
	}
	
	public void setClinical_feature(String clinical_feature) {
		this.clinical_feature = clinical_feature;
	}
	
	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="longtext")
	public String getDisease_prevention() {
		return disease_prevention;
	}
	
	public void setDisease_prevention(String disease_prevention) {
		this.disease_prevention = disease_prevention;
	}
	
	@Column(nullable=false)
	public String getBodyPartType() {
		return bodyPartType;
	}

	public void setBodyPartType(String bodyPartType) {
		this.bodyPartType = bodyPartType;
	}

	@Column(nullable=false)
	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Column(nullable=false)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(nullable=false)
	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	@Column(nullable=false)
	public String getFrom_type() {
		return from_type;
	}

	public void setFrom_type(String from_type) {
		this.from_type = from_type;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}