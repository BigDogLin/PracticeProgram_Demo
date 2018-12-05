package com.petshop.service;

import com.petshop.pojo.*;

public interface UserService {
	
	User login(String account, String password);
	
}
