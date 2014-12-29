package com.ctb.service.user;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springside.modules.security.utils.Digests;

import com.ctb.entity.user.User;
import com.ctb.entity.user.UserLog;
import com.ctb.repository.user.UserDao;
import com.ctb.repository.user.UserLogDao;
import com.ctb.service.ServiceException;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

@Component
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserLogDao userLogDao;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public String register(User user) throws ServiceException {

		/**
		 * 检查用户填写信息是否重复
		 */
		User $user = checkUserExist(user);

		/**
		 * 无用户名系统自动生成
		 */
		if ($user == null) {

			if (StringUtils.isEmpty(user.getUsername())) {
				user.setUsername("user" + RandomStringUtils.randomNumeric(8));
			}

			byte[] salt = Digests.generateSalt(8);
			user.setPassword(Base64.encode(Digests.sha1(user.getPassword().getBytes(), salt)));
			user.setSalt(Base64.encode(salt));

			userDao.save(user);

		} else if (!StringUtils.isEmpty(user.getUsername()) && $user.getUsername().equals(user.getUsername())) {
			throw new ServiceException("用户名已存在");
		} else if (!StringUtils.isEmpty(user.getEmail()) && $user.getEmail().equals(user.getEmail())) {
			throw new ServiceException("电子邮箱已存在");
		} else if (!StringUtils.isEmpty(user.getMobile()) && $user.getMobile().equals(user.getMobile())) {
			throw new ServiceException("移动电话已存在");
		}

		return user.getUsername();
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public String login(User user) throws ServiceException {

		/**
		 * 检查用户填写信息是否重复
		 */
		User $user = checkUserExist(user);

		if ($user == null) {
			throw new ServiceException("用户名不存在,请核实后重新登录");
		}

		/**
		 * 登录成功,生成accessToken并记录登录日志信息 登录失败,记录失败次数
		 */
		String accessToken = UUID.randomUUID().toString().replaceAll("-", "");
		
		byte[] salt = null;
		try {
			salt = Base64.decode($user.getSalt().getBytes());
		} catch (Base64DecodingException e) {
			e.printStackTrace();
		}
		
		if ($user.getPassword().equals(
				Base64.encode(Digests.sha1(user.getPassword().getBytes(), salt)))) {

			// LoginLog
			UserLog loginLog = new UserLog($user.getUsername(), "ip", new Date(), "brower", "system");
			userLogDao.save(loginLog);

			$user.setAccessToken(accessToken);
			$user.setLoginTime($user.getLoginTime() + 1);
			userDao.save($user);

			return accessToken;
		} else {
			$user.setLoginErrorTime($user.getLoginErrorTime() + 1);
			userDao.save($user);
			throw new ServiceException("密码错误");
		}

	}

	public User getLoginUser(String accessToken) throws ServiceException {
		User user = userDao.findByAccessToken(accessToken);
		if (user == null) {
			throw new ServiceException("该用户没有登录");
		}
		return user;
	}

	/**
	 * 检查用户是否存在
	 * 
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	private User checkUserExist(User user) throws ServiceException {

		User $user = null;
		if ($user == null && !StringUtils.isEmpty(user.getUsername())) {
			$user = userDao.findByUsername(user.getUsername());
		}
		
		if ($user == null && !StringUtils.isEmpty(user.getEmail())) {
			$user = userDao.findByEmail(user.getEmail());
		}
		
		if ($user == null && !StringUtils.isEmpty(user.getMobile())) {
			$user = userDao.findByMobile(user.getMobile());

		}
		return $user;
	}

}
