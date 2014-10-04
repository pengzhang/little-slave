package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.HospitalDepartment;
import com.ctb.repository.disease.HospitalDepartmentDao;


@Component
@Transactional
public class HospitalDepartmentService {
	
	private HospitalDepartmentDao hospitalDepartmentDao;

	@Autowired
	public void setHospitalDepartmentDao(HospitalDepartmentDao hospitalDepartmentDao) {
		this.hospitalDepartmentDao = hospitalDepartmentDao;
	}
	
	public void save(HospitalDepartment hospital_department){
		hospitalDepartmentDao.save(hospital_department);
	}

}
