package com.ctb.entity.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
@Table(name="gh_hospital_rank")
public class HospitalRank extends IdEntity {
	/**
	 * 排名次
	 */
	private String rankId;
	/**
	 * 医院名称
	 */
	private String hospitalName;
	/**
	 * 地区
	 */
	private String district;
	/**
	 * 专科声誉
	 */
	private String reputation;
	/**
	 * 科研学术
	 */
	private String scientificResearch;
	/**
	 * 总得分
	 */
	private String total;
	/**
	 * 排名年份
	 */
	private String year;
	
	@Column(nullable=false)
	public String getRankId() {
		return rankId;
	}

	public void setRankId(String rankId) {
		this.rankId = rankId;
	}
	@Column(nullable=false)
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	@Column(nullable=false)
	public String getScientificResearch() {
		return scientificResearch;
	}

	public void setScientificResearch(String scientificResearch) {
		this.scientificResearch = scientificResearch;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	@Column(nullable=false)
	public String getReputation() {
		return reputation;
	}

	public void setReputation(String reputation) {
		this.reputation = reputation;
	}

	@Column(nullable=false)
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	@Column(nullable=false)
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
