package com.ctb.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.post.Post;

public interface PostDao extends PagingAndSortingRepository<Post, Long> {
	
	Page<Post> findByUsername(String username,Pageable pageRequest);

}
