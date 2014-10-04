/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.repository.disease;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.disease.DepartmentDisease;

public interface DepartmentDiseaseDao extends PagingAndSortingRepository<DepartmentDisease, Long> {

	DepartmentDisease findByCode(String code);
	
	Page<DepartmentDisease> findAll(Pageable pageRequest);

}
