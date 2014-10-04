package com.ctb.entity.disease;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

/**
 * 身体部分名称
 * @author zhangpeng
 *
 */
@Entity
@Table(name = "body_part")
public class BodyPart extends IdEntity {
	
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
	
	public String getBodyPartUrl() {
		return bodyPartUrl;
	}
	
	public void setBodyPartUrl(String bodyPartUrl) {
		this.bodyPartUrl = bodyPartUrl;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
