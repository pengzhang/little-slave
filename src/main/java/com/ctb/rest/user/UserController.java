package com.ctb.rest.user;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.entity.user.User;
import com.ctb.rest.JerseyException;
import com.ctb.service.ServiceException;
import com.ctb.service.user.UserService;
import com.ctb.util.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/user")
@Api(value = "/user", description = "用户管理")
@Component
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Path("/register")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "用户信息管理", notes = "用户注册", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "操作失败"), @ApiResponse(code = 404, message = "地址无效") })
	public ObjectNode register(User user) {
		try {
			String username = userService.register(user);
			return Json.newObject().put("username", username);
		} catch (ServiceException e) {
			log.info(user.getUsername() + e.getMessage());
			throw new JerseyException("100000", e.getMessage());
		}

	}

	@Path("/login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "用户信息管理", notes = "用户登录", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "操作失败"), @ApiResponse(code = 404, message = "地址无效") })
	public ObjectNode login(User user) {
		try {
			String accessToken = userService.login(user);
			return Json.newObject().put("accessToken", accessToken);
		} catch (ServiceException e) {
			log.info(user.getUsername() + e.getMessage());
			throw new JerseyException("100001", e.getMessage());
		}

	}

	@Path("/get/user/{accessToken}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "用户信息管理", notes = "获取用户信息AccessToken", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "操作失败"), @ApiResponse(code = 404, message = "地址无效") })
	public JsonNode getLoginUserByAccessToken(
			@ApiParam(value = "AccessToken", required = true) @PathParam("accessToken") String accessToken) {
		try {
			return Json.toJson(userService.getLoginUser(accessToken));
		} catch (ServiceException e) {
			log.info(accessToken + e.getMessage());
			throw new JerseyException("100002", e.getMessage());
		}
	}
}
