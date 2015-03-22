package com.photography.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photography.dao.User;
import com.photography.dao.UsersDao;

@Service
public class UsersService {

	@Autowired
	private UsersDao usersDao;
	
	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	public void create(User user) {
		usersDao.create(user);
	}

	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}

	public User getUser(String username) {
		return usersDao.getUser(username);
	}

	
}
