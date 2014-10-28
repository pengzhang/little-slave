/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.repository.hospital;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.hospital.HospitalDepartRank;

public interface HospitalDepartRankDao extends PagingAndSortingRepository<HospitalDepartRank, Long> {

	HospitalDepartRank findByCode(String code);


}
