package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {
	/**
	 * ע���û�
	 * @param user
	 */
	public void regist(User user);
	/**
	 * �û���¼
	 * @param user
	 * @return
	 */
	public User login(User user);
}
