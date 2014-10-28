package com.ctb.service.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.hospital.Hospital;
import com.ctb.repository.hospital.HospitalDao;


@Component
@Transactional
public class HospitalService {
	
	private HospitalDao hospitalDao;
	
	public void save(Hospital hospital){
		hospitalDao.save(hospital);
	}
	
	@Autowired
	public void setHospitalRankDao(HospitalDao hospitalDao) {
		this.hospitalDao = hospitalDao;
	}

}
