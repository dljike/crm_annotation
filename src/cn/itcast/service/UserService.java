package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
	/**
	 * �û�ע��
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
