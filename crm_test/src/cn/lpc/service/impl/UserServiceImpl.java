package cn.lpc.service.impl;


import java.util.List;

import cn.lpc.dao.UserDao;
import cn.lpc.domain.User;
import cn.lpc.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> findOne(User user) {
		return userDao.findOne(user);
	}

	@Override
	public List<User> finAll() {
		return userDao.findAll();
	}

}
