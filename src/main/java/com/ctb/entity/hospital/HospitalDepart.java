package com.ctb.entity.hospital;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.ctb.entity.IdEntity;

@Entity
@Table(name="hospital_depart")
public class HospitalDepart extends IdEntity {
	
	/**
	 * 科室名称
	 */
	private String departName;
	
	@Column(nullable=false)
	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
