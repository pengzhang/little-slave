package com.ctb.entity.disease;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

/**
 * 身体部分的疾病名称
 * @author zhangpeng
 *
 */
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
	
	@Column(nullable=false)
	public String getBodyPartType() {
		return bodyPartType;
	}

	public void setBodyPartType(String bodyPartType) {
		this.bodyPartType = bodyPartType;
	}

	@Column(nullable=false)
	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	@Column(nullable=false)
	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Column(nullable=false)
	public String getBodyPartUrl() {
		return bodyPartUrl;
	}

	public void setBodyPartUrl(String bodyPartUrl) {
		this.bodyPartUrl = bodyPartUrl;
	}

	@Column(nullable=false)
	public String getDiseaseUrl() {
		return diseaseUrl;
	}

	public void setDiseaseUrl(String diseaseUrl) {
		this.diseaseUrl = diseaseUrl;
	}

	@Column(nullable=false)
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