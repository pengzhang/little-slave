package com.ctb.entity.post;

import java.util.Date;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
public class MyMemorialDay extends IdEntity{

	private String username;
	private Date memorialDay;         //纪念日日期
	private String memorialDayName;   //纪念日名称
	private String recommend; //推荐内容
	private int countDown;  //倒计时
	//纪念日记录
	private String postTitle;
	private String postContent;
	private String picUrl;
	private String picUrlDesc;
	private Date createDate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getMemorialDay() {
		return memorialDay;
	}
	public void setMemorialDay(Date memorialDay) {
		this.memorialDay = memorialDay;
	}
	public String getMemorialDayName() {
		return memorialDayName;
	}
	public void setMemorialDayName(String memorialDayName) {
		this.memorialDayName = memorialDayName;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public int getCountDown() {
		return countDown;
	}
	public void setCountDown(int countDown) {
		this.countDown = countDown;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getPicUrlDesc() {
		return picUrlDesc;
	}
	public void setPicUrlDesc(String picUrlDesc) {
		this.picUrlDesc = picUrlDesc;
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
