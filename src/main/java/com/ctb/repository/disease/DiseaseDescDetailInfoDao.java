/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.repository.disease;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.disease.DiseaseDescDetailInfo;

public interface DiseaseDescDetailInfoDao extends PagingAndSortingRepository<DiseaseDescDetailInfo, Long> {

	DiseaseDescDetailInfo findByCode(String code);

}