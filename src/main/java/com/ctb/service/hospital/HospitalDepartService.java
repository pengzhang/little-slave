package com.ctb.service.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.hospital.HospitalRank;
import com.ctb.repository.hospital.HospitalRankDao;


@Component
@Transactional
public class HospitalDepartService {
	
	private HospitalRankDao hospitalRankDao;
	
	public void save(HospitalRank hospitalRank){
		hospitalRankDao.save(hospitalRank);
	}
	
	@Autowired
	public void setHospitalRankDao(HospitalRankDao hospitalRankDao) {
		this.hospitalRankDao = hospitalRankDao;
	}

}
