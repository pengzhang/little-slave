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
import com.ctb.entity.user.UserScore;
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
			
			scoreProccess(user.getUsername(), UserScore.REGISTER);

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

		if (!$user.isStatus()) {
			throw new ServiceException("该用户已被禁用");
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

		if ($user.getPassword().equals(Base64.encode(Digests.sha1(user.getPassword().getBytes(), salt)))) {

			// LoginLog
			UserLog loginLog = new UserLog($user.getUsername(), "ip", new Date(), "brower", "system");
			userLogDao.save(loginLog);

			$user.setAccessToken(accessToken);
			$user.setLoginTime($user.getLoginTime() + 1);
			userDao.save($user);
			scoreProccess($user.getUsername(), UserScore.LOGIN);
			
			return accessToken;
		} else {
			$user.setLoginErrorTime($user.getLoginErrorTime() + 1);
			userDao.save($user);
			throw new ServiceException("密码错误");
		}

	}

	/**
	 * 获取登录用户信息
	 * 
	 * @param accessToken
	 * @return
	 * @throws ServiceException
	 */
	public User getLoginUser(String accessToken) throws ServiceException {
		User user = userDao.findByAccessToken(accessToken);
		if (user == null) {
			throw new ServiceException("该用户没有登录");
		}
		return user;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public boolean modifyUser(User user) throws ServiceException {

		// TODO 细节处理,Email,Mobile验证
		try {
			userDao.save(user);
			return true;
		} catch (Exception e) {
			throw new ServiceException("修改用户失败");
		}
	}

	/**
	 * 修改密码和重置密码
	 * 
	 * @param username
	 * @param oldPassword
	 * @param newPassword
	 * @param check
	 * @return
	 * @throws ServiceException
	 */
	public boolean modifyPassword(String username, String oldPassword, String newPassword, boolean check)
			throws ServiceException {
		try {
			User $user = checkUsernameExist(username);

			if ($user == null) {
				throw new ServiceException("该用户不存在");
			} else {
				if (check) {
					if (!$user.getPassword().equals(oldPassword)) {
						throw new ServiceException("旧密码错误");
					}
				}

				byte[] salt = Digests.generateSalt(8);
				$user.setPassword(Base64.encode(Digests.sha1(newPassword.getBytes(), salt)));
				$user.setSalt(Base64.encode(salt));
				userDao.save($user);
				return true;
			}

		} catch (ServiceException e) {
			throw new ServiceException("修改密码失败");
		}
	}

	/**
	 * 检查Email是否存在
	 * 
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public boolean checkEmailExist(User user) throws ServiceException {

		
		checkUsernameExist(user.getUsername());

		User $user = null;
		if (!StringUtils.isEmpty(user.getEmail())) {
			$user = userDao.findByEmail(user.getEmail());
		}

		if ($user == null) {
			return true;
		} else {
			if (!$user.getUsername().equals(user.getUsername())) {
				return false;
			} else {
				return true;
			}

		}

	}

	/**
	 * 检查Mobile是否存在
	 * 
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public boolean checkMobileExist(User user) throws ServiceException {

		checkUsernameExist(user.getUsername());

		User $user = null;

		if (!StringUtils.isEmpty(user.getMobile())) {
			$user = userDao.findByMobile(user.getMobile());
		}

		if ($user == null) {
			return true;

		} else {
			if (!$user.getUsername().equals(user.getUsername())) {
				return false;
			} else {
				return true;
			}
		}

	}
	
	/**
	 * 积分处理
	 * @param username
	 * @param operaType
	 */
	private void scoreProccess(String username, long operaType){
		User $user = checkUsernameExist(username);
		$user.setScore($user.getScore() + operaType);
		userDao.save($user);
		
	}
	
	/**
	 * 检查用户名查询用户是否存在
	 * @param username
	 * @return
	 * @throws ServiceException
	 */
	private User checkUsernameExist(String username) throws ServiceException{
		User $user = null;
		if (!StringUtils.isEmpty(username)) {
			$user = userDao.findByUsername(username);
			if ( $user == null) {
				throw new ServiceException("该用户不存在");
			}
		}
		return $user;
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
