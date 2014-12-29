package com.ctb.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.repository.resource.ChildReadingDao;

@Component
@Transactional
public class ChildReadingService {
	
	@Autowired
	private ChildReadingDao childReadingDao;

}
