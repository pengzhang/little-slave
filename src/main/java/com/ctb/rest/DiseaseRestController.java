/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.rest;

import java.util.List;

import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.entity.BodyPartDisease;
import com.ctb.service.disease.BodyPartDiseaseService;
import com.ctb.service.disease.SinaHealthCollect;
import com.ctb.util.ConfigUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author zp
 */

@Path("/disease")
@Api(value="/disease" , description = "健康自检管理")
@Component
public class DiseaseRestController {

	private static Logger logger = LoggerFactory.getLogger(DiseaseRestController.class);

	@Autowired
	private BodyPartDiseaseService bodyPartDiseaseService;

	@Autowired
	private Validator validator;

	@GET
	@Path("/collect")
	@Produces(MediaType.APPLICATION_JSON)
	 @ApiOperation(value = "采集按部位疾病信息", notes = "从新浪健康频道,采集按部位疾病信息",response = String.class)
	 @ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"),
	 @ApiResponse(code = 404, message = "地址无效") })
	public MessageBean collet() {
		logger.info("开始采集按部位疾病信息数据...");
		List<BodyPartDisease> bodyPartDiseases=  SinaHealthCollect.collectBodyPartInfo(ConfigUtil.readValue("sina_health_btb"));
		for(BodyPartDisease bodyPartDisease : bodyPartDiseases){
			bodyPartDiseaseService.save(bodyPartDisease);
		}
		logger.info("按部位疾病信息数据采集完毕!" );
		return RestMessage.getMessageBean("body_part_disease_collect");
	}

}
