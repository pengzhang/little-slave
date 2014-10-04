package com.ctb.service.disease;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.repository.disease.DepartmentDiseaseDao;
import com.ctb.repository.disease.HospitalDepartmentDao;

@Component
public class SinaHealthDepartmentCollect {

	public static Logger logger = LoggerFactory.getLogger(SinaHealthDepartmentCollect.class);

	@Autowired
	private DepartmentDiseaseDao departmentDiseaseDao;
	
	@Autowired
	private HospitalDepartmentDao hospitalDepartmentDao;

}