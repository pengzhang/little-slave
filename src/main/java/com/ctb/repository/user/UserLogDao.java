package com.ctb.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.user.UserLog;

public interface UserLogDao extends PagingAndSortingRepository<UserLog, Long> {

}
