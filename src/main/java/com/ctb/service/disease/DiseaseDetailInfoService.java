package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.DiseaseDetailInfo;
import com.ctb.repository.disease.DiseaseDetailInfoDao;


@Component
@Transactional
public class DiseaseDetailInfoService {
	
	private DiseaseDetailInfoDao diseaseDetailInfoDao;

	@Autowired
	public void setDiseaseDetailInfoDao(DiseaseDetailInfoDao diseaseDetailInfoDao) {
		this.diseaseDetailInfoDao = diseaseDetailInfoDao;
	}
	
	public void save(DiseaseDetailInfo disease_detail_info){
		diseaseDetailInfoDao.save(disease_detail_info);
	}
	
	public DiseaseDetailInfo getDiseaseDetailInfo( String code){
		return diseaseDetailInfoDao.findByCode(code);
	}

}
