package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.DiseaseInfo;
import com.ctb.repository.disease.DiseaseInfoDao;


@Component
@Transactional
public class DiseaseInfoService {
	
	private DiseaseInfoDao diseaseInfoDao;

	@Autowired
	public void setDiseaseDao(DiseaseInfoDao diseaseInfoDao) {
		this.diseaseInfoDao = diseaseInfoDao;
	}
	
	public void save(DiseaseInfo disease_info){
		diseaseInfoDao.save(disease_info);
	}

}
