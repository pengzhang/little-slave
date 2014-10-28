/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.repository.hospital;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.hospital.Hospital;

public interface HospitalDao extends PagingAndSortingRepository<Hospital, Long> {

	HospitalDao findByCode(String code);
	
	HospitalDao findByHospitalName(String hospitalName);
	

}
