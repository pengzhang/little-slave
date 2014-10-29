/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ctb.rest.disease;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.entity.disease.BodyPartDisease;
import com.ctb.entity.disease.DiseaseDetailInfo;
import com.ctb.entity.disease.DiseaseInfo;
import com.ctb.service.disease.BodyPartDiseaseService;
import com.ctb.service.disease.DiseaseDetailInfoService;
import com.ctb.service.disease.DiseaseInfoService;
import com.ctb.util.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author zp
 */
@Path("/sc")
@Api(value = "/sc", description = "按身体部位查询")
@Component
public class SelfCheckController {

//	private static Logger logger = LoggerFactory.getLogger(RestController.class);

	@Autowired
	private BodyPartDiseaseService bodyPartDiseaseService;
	
	@Autowired
	private DiseaseInfoService diseaseInfoService;
	
	@Autowired
	private DiseaseDetailInfoService diseaseDetailInfoService;

	
	@GET
	@Path("/bodypart/{bodypart}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "通过身体具体部分获取疾病列表", notes = "通过身体具体部分获取疾病列表", response = BodyPartDisease.class,responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public JsonNode bodyPart(
			@ApiParam(value = "身体部位", required = true) @PathParam("bodypart") String bodypart
			) {
		return Json.toJson(bodyPartDiseaseService.findBybodyPart(bodypart));
	}
	
	
	@GET
	@Path("/bodypart/type/{bodypart}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "通过身体大部分获取疾病列表", notes = "通过身体大部分获取疾病列表", response = BodyPartDisease.class,responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public JsonNode bodyPartType(
			@ApiParam(value = "身体部位", required = true) @PathParam("bodypart") String bodypart
			) {
		return Json.toJson(bodyPartDiseaseService.findBybodyPartType(bodypart));
	}
	
	@GET
	@Path("/bodypart/disease/page/{page}/size/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "分页获取部位疾病信息", notes = "分页获取部位疾病信息", response = BodyPartDisease.class,responseContainer="List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public JsonNode getBodyPartDisease(
			@ApiParam(value = "页数", allowableValues = "range[1,5]", required = true) @PathParam("page") String page,
			@ApiParam(value = "每页的条数", allowableValues = "range[1,5]", required = true) @PathParam("size") String size) {

		return Json.toJson(bodyPartDiseaseService.getBodyPartDisease(Integer.parseInt(page), Integer.parseInt(size), "auto").getContent());
	}
	
	@GET
	@Path("/disease/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "通过Code获取疾病信息", notes = "通过Code获取疾病信息", response = DiseaseInfo.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public JsonNode diseaseBycode(
			@ApiParam(value = "疾病Code", required = true) @PathParam("code") String code
			) {
		return Json.toJson(diseaseInfoService.getDiseaseInfo(code));
	}
	
	@GET
	@Path("/disease/detail/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "通过Code获取疾病详细信息", notes = "通过Code获取疾病详细信息", response = DiseaseDetailInfo.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "创建失败"), @ApiResponse(code = 404, message = "地址无效") })
	public JsonNode diseaseDetailBycode(
			@ApiParam(value = "疾病Code", required = true) @PathParam("code") String code
			) {
		return Json.toJson(diseaseDetailInfoService.getDiseaseDetailInfo(code));
	}


	
	
}
