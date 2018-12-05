package com.petshop.dao;

import com.petshop.pojo.*;

public interface UserDao {

    User queryUserByAccount(String account);

}
