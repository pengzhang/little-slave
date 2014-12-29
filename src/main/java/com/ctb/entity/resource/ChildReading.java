package com.ctb.entity.resource;

import java.util.Date;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
public class ChildReading extends IdEntity {

	private String readingType;
	private String readingTitle;
	private String readingContent;
	private Date createDate;
	
	public String getReadingType() {
		return readingType;
	}
	public void setReadingType(String readingType) {
		this.readingType = readingType;
	}
	public String getReadingTitle() {
		return readingTitle;
	}
	public void setReadingTitle(String readingTitle) {
		this.readingTitle = readingTitle;
	}
	public String getReadingContent() {
		return readingContent;
	}
	public void setReadingContent(String readingContent) {
		this.readingContent = readingContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
