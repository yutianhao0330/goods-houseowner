package com.thyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thyu.bean.User;
import com.thyu.dao.UserDao;
import com.thyu.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}
	
}
