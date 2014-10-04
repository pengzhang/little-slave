/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.entity.disease.BodyPartDisease;
import com.ctb.service.disease.BodyPartDiseaseService;
import com.ctb.service.disease.SinaHealthPartCollect;
import com.ctb.util.ConfigUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author zp
 */

@Path("/disease")
@Api(value = "/disease", description = "健康自检管理")
@Component
public class DiseaseRestController {

	private static Logger logger = LoggerFactory.getLogger(DiseaseRestController.class);

	@Autowired
	private SinaHealthPartCollect sinaHealthPartCollect;

	@Autowired
	private BodyPartDiseaseService bodyPartDiseaseService;

	@GET
	@Path("/collect")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "采集按部位疾病信息", notes = "从新浪健康频道,采集按部位疾病信息", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public MessageBean collet() {
		logger.info("开始采集按部位疾病信息数据...");
		sinaHealthPartCollect.collectBodyPartInfo(ConfigUtil.readValue("sina_health_btb"));
		logger.info("按部位疾病信息数据采集完毕!");
		return RestMessage.getMessageBean("body_part_disease_collect");
	}

	@GET
	@Path("/get/page/{page}/size/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "分页获取部位疾病信息", notes = "分页获取部位疾病信息", response = BodyPartDisease.class, responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public List<BodyPartDisease> getBodyPartDisease(
			@ApiParam(value = "页数", allowableValues = "range[1,5]", required = true) @PathParam("page") String page,
			@ApiParam(value = "每页的条数", allowableValues = "range[1,5]", required = true) @PathParam("size") String size) {

		return bodyPartDiseaseService.getBodyPartDisease(Integer.parseInt(page), Integer.parseInt(size), "auto").getContent();
	}

}
