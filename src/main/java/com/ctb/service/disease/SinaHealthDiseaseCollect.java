package com.ctb.service.disease;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.repository.disease.DiseaseDescDetailInfoDao;
import com.ctb.repository.disease.DiseaseInfoDao;
import com.ctb.repository.disease.DiseasePreventionDetailInfoDao;

@Component
public class SinaHealthDiseaseCollect {

	public static Logger logger = LoggerFactory.getLogger(SinaHealthDiseaseCollect.class);

	@Autowired
	private BodyPartDiseaseService bodyPartDiseaseService;
	
	@Autowired
	private DiseaseInfoDao diseaseInfoDao;
	
	@Autowired
	private DiseaseDescDetailInfoDao diseaseDescDetailInfoDao;
	
	@Autowired
	private DiseasePreventionDetailInfoDao diseasePreventionDetailInfoDao;

}