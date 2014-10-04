package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.BodyPart;
import com.ctb.repository.disease.BodyPartDao;


@Component
@Transactional
public class BodyPartService {
	
	private BodyPartDao bodyPartDao;

	@Autowired
	public void setBodyPartDao(BodyPartDao bodyPartDao) {
		this.bodyPartDao = bodyPartDao;
	}
	
	public void save(BodyPart bodyPart){
		bodyPartDao.save(bodyPart);
	}

}
