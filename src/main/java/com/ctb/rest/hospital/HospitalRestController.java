/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.rest.hospital;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.rest.RestMessage;
import com.ctb.rest.ReturnMessageBean;
import com.ctb.service.hospital.collect.GuaHaoHospitalRankCollect;
import com.ctb.util.ConfigUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author zp
 */

@Path("/collect/guahao")
@Api(value = "/collect/guahao", description = "挂号网采集管理")
@Component
public class HospitalRestController {

	private static Logger logger = LoggerFactory.getLogger(HospitalRestController.class);

	@Autowired
	private GuaHaoHospitalRankCollect  guaHaoHospitalRankCollect;
	
	@GET
	@Path("/rank/hospital")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "采集医院排行榜信息", notes = "从挂号网,采集医院排行榜信息", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public ReturnMessageBean collectHospitalRank() {
		logger.info("开始采集医院排行榜信息...");
		guaHaoHospitalRankCollect.collectHospitalRank(ConfigUtil.readValue("rank_hospital_2012"), "2012");
		guaHaoHospitalRankCollect.collectHospitalRank(ConfigUtil.readValue("rank_hospital_2011"), "2011");
		guaHaoHospitalRankCollect.collectHospitalRank(ConfigUtil.readValue("rank_hospital_2010"), "2010");
		logger.info("医院排行榜信息采集完毕!");
		return RestMessage.getMessageBean("rank_hospital_collect");
	}
	
	@GET
	@Path("/rank/department")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "采集按科室医院排行榜信息", notes = "从挂号网,采集按科室医院排行榜信息", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public ReturnMessageBean collectHospitalDepartRank() {
		logger.info("开始按科室采集医院排行榜信息...");
		guaHaoHospitalRankCollect.collectHospitalDepartRank(ConfigUtil.readValue("rank_department_2012"), "2012");
		guaHaoHospitalRankCollect.collectHospitalDepartRank(ConfigUtil.readValue("rank_department_2011"), "2011");
		guaHaoHospitalRankCollect.collectHospitalDepartRank(ConfigUtil.readValue("rank_department_2010"), "2010");
		logger.info("按科室医院排行榜信息采集完毕!");
		return RestMessage.getMessageBean("rank_department_collect");
	}
	
	
}
