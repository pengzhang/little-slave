package com.ctb.service.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.hospital.HospitalDepartRank;
import com.ctb.repository.hospital.HospitalDepartRankDao;


@Component
@Transactional
public class HospitalDepartRankService {
	
	private HospitalDepartRankDao hospitalDepartRankDao;
	
	public void save(HospitalDepartRank hospitalDepartRank){
		hospitalDepartRankDao.save(hospitalDepartRank);
	}
	
	@Autowired
	public void setHospitalRankDao(HospitalDepartRankDao hospitalDepartRankDao) {
		this.hospitalDepartRankDao = hospitalDepartRankDao;
	}

}
