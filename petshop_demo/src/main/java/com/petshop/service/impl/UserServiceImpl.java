package com.petshop.service.impl;

import com.petshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petshop.dao.*;
import com.petshop.pojo.*;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userdao;
	
	public User login(String account, String password) {
		User user = userdao.queryUserByAccount(account);
		if(user != null && password.equals(user.getPassword())) {
			user.setPassword(null);
			return user;
		}else {
			return null;
		}
	}
}
