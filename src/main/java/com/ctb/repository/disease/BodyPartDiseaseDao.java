/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.repository.disease;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.disease.BodyPartDisease;

public interface BodyPartDiseaseDao extends PagingAndSortingRepository<BodyPartDisease, Long> {

	BodyPartDisease findByCode(String code);
	
	List<BodyPartDisease> findBybodyPartType(String bodypart);
	
	List<BodyPartDisease> findBybodyPart(String bodypart);
	
	Page<BodyPartDisease> findAll(Pageable pageRequest);

}
