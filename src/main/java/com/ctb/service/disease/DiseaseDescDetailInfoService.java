package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.DiseaseDescDetailInfo;
import com.ctb.repository.disease.DiseaseDescDetailInfoDao;


@Component
@Transactional
public class DiseaseDescDetailInfoService {
	
	private DiseaseDescDetailInfoDao diseaseDescDetailInfoDao;

	@Autowired
	public void setDiseaseDao(DiseaseDescDetailInfoDao diseaseDescDetailInfoDao) {
		this.diseaseDescDetailInfoDao = diseaseDescDetailInfoDao;
	}
	
	public void save(DiseaseDescDetailInfo disease_desc_detail_info){
		diseaseDescDetailInfoDao.save(disease_desc_detail_info);
	}

}
