package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.DiseasePreventionDetailInfo;
import com.ctb.repository.disease.DiseasePreventionDetailInfoDao;


@Component
@Transactional
public class DiseasePreventionDetailInfoService {
	
	private DiseasePreventionDetailInfoDao diseasePreventionDetailInfoDao;

	@Autowired
	public void setDiseaseDao(DiseasePreventionDetailInfoDao diseasePreventionDetailInfoDao) {
		this.diseasePreventionDetailInfoDao = diseasePreventionDetailInfoDao;
	}
	
	public void save(DiseasePreventionDetailInfo disease_desc_detail_info){
		diseasePreventionDetailInfoDao.save(disease_desc_detail_info);
	}

}
