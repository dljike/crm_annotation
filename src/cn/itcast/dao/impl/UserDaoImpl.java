package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 注册用户
	 */
	@Override
	public void regist(User user) {
		hibernateTemplate.save(user);
		System.out.println("注册用户");
	}
	/**
	 * 用户登录
	 */
	@Override
	public User login(User user) {
		 List<User> list = (List<User>) hibernateTemplate.find("from User where user_code=? and user_password=?", user.getUser_code(),user.getUser_password());
		 if (list.size()>0) {
			return list.get(0);
		}
		 return null;
	}

}
