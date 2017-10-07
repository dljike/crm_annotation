package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
	/**
	 * 用户注册
	 * @param user
	 */
	public void regist(User user);
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);

}
