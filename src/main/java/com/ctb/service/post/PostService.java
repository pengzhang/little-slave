package com.ctb.service.post;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.post.Post;
import com.ctb.repository.post.PostDao;
import com.ctb.service.ServiceException;


@Component
@Transactional
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	/**
	 * 上传帖子
	 * @param post
	 * @throws ServiceException
	 */
	public boolean uploadPost(Post post) throws ServiceException{
		
		try{
			post.setCreateDate(new Date());
			postDao.save(post);
			return true;
		}catch(ServiceException e){
			throw new ServiceException("上传帖子失败");
		}
	}
	
	/**
	 * 修改帖子
	 * @param post
	 * @return
	 * @throws ServiceException
	 */
	public boolean modifyPost(Post post) throws ServiceException {
		try{
			post.setUpdateDate(new Date());
			postDao.save(post);
			return true;
		}catch(ServiceException e){
			throw new ServiceException("修改帖子失败");
		}
	}
	
	public Page<Post> getPosts(String username,int page, int size, String sortField,String sortType) throws ServiceException {
		try{
			return postDao.findByUsername(username, buildPageRequest(page, size, sortField, sortType));
		}catch(ServiceException e){
			throw new ServiceException("查询帖子失败");
		}
		
	}
	
	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortField, String sortType ) {
		Sort sort = null;
		if (sortType.equalsIgnoreCase("desc")) {
			sort = new Sort(Direction.DESC, sortField);
		}else{
			sort = new Sort(Direction.ASC, sortField);
		}
		return new PageRequest(pageNumber - 1, pageSize, sort);
	}

}
