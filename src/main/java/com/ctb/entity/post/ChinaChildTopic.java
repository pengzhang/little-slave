package com.ctb.entity.post;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
public class ChinaChildTopic extends IdEntity {
	
	private String username;
	private String postCode;
	private long liked;
	private long hated;
	private String nationRank;
	private String friendRank;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public long getLiked() {
		return liked;
	}
	public void setLiked(long liked) {
		this.liked = liked;
	}
	public long getHated() {
		return hated;
	}
	public void setHated(long hated) {
		this.hated = hated;
	}
	public String getNationRank() {
		return nationRank;
	}
	public void setNationRank(String nationRank) {
		this.nationRank = nationRank;
	}
	public String getFriendRank() {
		return friendRank;
	}
	public void setFriendRank(String friendRank) {
		this.friendRank = friendRank;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
