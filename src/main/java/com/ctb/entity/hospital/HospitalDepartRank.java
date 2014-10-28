package com.ctb.entity.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
@Table(name="hospital_rank")
public class HospitalDepartRank extends IdEntity {
	/**
	 * 排名次
	 */
	private String rankId;
	/**
	 * 医院科室Code
	 */
	private String hospitalDepartCode;
	/**
	 * 医院名称
	 */
	private String hospitalName;
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
	public String getHospitalDepartCode() {
		return hospitalDepartCode;
	}

	public void setHospitalDepartCode(String hospitalDepartCode) {
		this.hospitalDepartCode = hospitalDepartCode;
	}
	@Column(nullable=false)
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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
