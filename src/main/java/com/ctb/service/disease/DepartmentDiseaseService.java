package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.DepartmentDisease;
import com.ctb.repository.disease.DepartmentDiseaseDao;


@Component
@Transactional
public class DepartmentDiseaseService {
	
	private DepartmentDiseaseDao departmentDiseaseDao;

	@Autowired
	public void setDepartmentDiseaseDao(DepartmentDiseaseDao departmentDiseaseDao) {
		this.departmentDiseaseDao = departmentDiseaseDao;
	}
	
	public void save(DepartmentDisease department_disease){
		departmentDiseaseDao.save(department_disease);
	}

}
