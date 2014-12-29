package com.ctb.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctb.entity.user.AdminUser;

public interface AdminUserDao extends PagingAndSortingRepository<AdminUser, Long> {

}
