package com.ctb.rest.post;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.entity.post.Post;
import com.ctb.rest.JerseyException;
import com.ctb.service.ServiceException;
import com.ctb.service.post.PostService;
import com.ctb.util.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/post")
@Api(value = "/post", description = "帖子管理")
@Component
public class PostController {

	private static Logger log = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	@Path("/upload")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	@ApiOperation(value = "上传帖子", notes = "帖子管理-上传帖子", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "操作失败"), @ApiResponse(code = 404, message = "地址无效") })
	public ObjectNode post(Post post) {
		try {
			boolean flag = postService.uploadPost(post);
			return Json.newObject().put("status", flag);
		} catch (ServiceException e) {
			log.info(post.getPostTitle() + e.getMessage());
			throw new JerseyException("200000", e.getMessage());
		}

	}
	
	@Path("/get/{username}/{page}/{size}/{sortField}/{sortType}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "获取用户帖子", notes = "帖子管理-获取用户帖子", response = Post.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "操作失败"), @ApiResponse(code = 404, message = "地址无效") })
	public JsonNode getUserPost(
			@ApiParam(value="用户名",required=true) @PathParam("username") String username,
			@ApiParam(value="页码",required=true) @PathParam("page") int page,
			@ApiParam(value="条数",required=true) @PathParam("size") int size,
			@ApiParam(value="排序字段",required=false) @PathParam("sortField") String sortField,
			@ApiParam(value="排序方式",required=false) @PathParam("sortType") String sortType
			) {
		try {
			if(StringUtils.isEmpty(sortField)){
				sortField = "id";
			}
			
			if(StringUtils.isEmpty(sortType)){
				sortType = "DESC";
			}
			
			return Json.toJson(postService.getPosts(username, page, size, sortField,sortType));
		} catch (ServiceException e) {
			log.info(username + e.getMessage());
			throw new JerseyException("200001", e.getMessage());
		}

	}
	
}
