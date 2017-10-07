package cn.itcast.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * �û�ע��
	 */
	@Override
	public void regist(User user) {
		user.setUser_state("1");
		userDao.regist(user);
	}

	/**
	 * �û���¼
	 */
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
