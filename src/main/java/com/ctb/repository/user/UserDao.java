package com.ctb.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.user.User;

public interface UserDao extends PagingAndSortingRepository<User,Long> {

	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User findByMobile(String mobile);
	
	User findByAccessToken(String accessToken);
	
	
}
