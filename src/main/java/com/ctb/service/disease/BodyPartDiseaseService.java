package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.BodyPartDisease;
import com.ctb.repository.BodyPartDiseaseDao;


@Component
@Transactional
public class BodyPartDiseaseService {
	
	private BodyPartDiseaseDao bodyPartDiseaseDao;

	@Autowired
	public void setBodyPartDiseaseDao(BodyPartDiseaseDao bodyPartDiseaseDao) {
		this.bodyPartDiseaseDao = bodyPartDiseaseDao;
	}
	
	public void save(BodyPartDisease bodyPartDisease){
		bodyPartDiseaseDao.save(bodyPartDisease);
	}

}
