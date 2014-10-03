package com.ctb.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "body_part_disease")
public class BodyPartDisease extends IdEntity {

	/**
	 * 大部位名称
	 */
	private String bodyPartType;
	/**
	 * 具体部位名称
	 */
	private String bodyPart;
	/**
	 * 疾病信息采集网址
	 */
	private String bodyPartUrl;
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
	
	public String getBodyPartType() {
		return bodyPartType;
	}

	public void setBodyPartType(String bodyPartType) {
		this.bodyPartType = bodyPartType;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getBodyPartUrl() {
		return bodyPartUrl;
	}

	public void setBodyPartUrl(String bodyPartUrl) {
		this.bodyPartUrl = bodyPartUrl;
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