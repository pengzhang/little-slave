package com.ctb.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.repository.user.AdminUserDao;
import com.ctb.repository.user.UserLogDao;


@Component
@Transactional
public class AdminUserService {
	
	@Autowired
	private AdminUserDao adminUserDao;
	@Autowired
	private UserLogDao userLogDao;

}
