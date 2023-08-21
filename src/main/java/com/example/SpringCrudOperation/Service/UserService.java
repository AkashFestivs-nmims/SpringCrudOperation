package com.example.SpringCrudOperation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringCrudOperation.Bean.Users;
import com.example.SpringCrudOperation.Dao.UserDao;

@Service("userService")
public class UserService {
	
	@Autowired
	UserDao userDao;

	public Users findUserByUsername(String username, String password) {
		return userDao.findUserByUsername(username, password);
		
	}
}
