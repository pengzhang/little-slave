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
 * 疾病五项详细信息
 * @author zhangpeng
 *
 */
@Entity
@Table(name="disease_detail_info")
public class DiseaseDetailInfo extends IdEntity {
	
	/**
	 * 疾病code
	 */
	private String disease_code;
	/**
	 * 疾病概述详细信息
	 */
	private String disease_description_detail;
	/**
	 * 临床表现详细信息
	 */
	private String clinical_feature_detail;
	/**
	 * 疾病预防详细信息
	 */
	private String disease_prevention_detail;
	/**
	 * 疾病检查详细信息
	 */
	private String disease_check_detail;
	/**
	 * 疾病治疗详细信息
	 */
	private String disease_cure_detail;

	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="LONGTEXT")
	public String getDisease_description_detail() {
		return disease_description_detail;
	}

	public void setDisease_description_detail(String disease_description_detail) {
		this.disease_description_detail = disease_description_detail;
	}
	@Column(nullable=false)
	public String getDisease_code() {
		return disease_code;
	}

	public void setDisease_code(String disease_code) {
		this.disease_code = disease_code;
	}

	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="LONGTEXT")
	public String getClinical_feature_detail() {
		return clinical_feature_detail;
	}

	public void setClinical_feature_detail(String clinical_feature_detail) {
		this.clinical_feature_detail = clinical_feature_detail;
	}

	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="LONGTEXT")
	public String getDisease_prevention_detail() {
		return disease_prevention_detail;
	}

	public void setDisease_prevention_detail(String disease_prevention_detail) {
		this.disease_prevention_detail = disease_prevention_detail;
	}

	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="LONGTEXT")
	public String getDisease_check_detail() {
		return disease_check_detail;
	}

	public void setDisease_check_detail(String disease_check_detail) {
		this.disease_check_detail = disease_check_detail;
	}

	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(nullable=false,columnDefinition="LONGTEXT")
	public String getDisease_cure_detail() {
		return disease_cure_detail;
	}

	public void setDisease_cure_detail(String disease_cure_detail) {
		this.disease_cure_detail = disease_cure_detail;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}