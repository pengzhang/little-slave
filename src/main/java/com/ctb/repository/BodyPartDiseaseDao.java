/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.BodyPartDisease;

public interface BodyPartDiseaseDao extends PagingAndSortingRepository<BodyPartDisease, Long> {

	BodyPartDisease findByCode(String code);


}