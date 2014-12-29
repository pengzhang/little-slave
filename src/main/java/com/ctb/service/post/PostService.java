package com.ctb.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.repository.post.PostDao;


@Component
@Transactional
public class PostService {
	
	@Autowired
	private PostDao postDao;

}
