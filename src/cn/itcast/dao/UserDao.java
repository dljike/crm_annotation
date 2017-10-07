package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
	/**
	 * 注册用户
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
