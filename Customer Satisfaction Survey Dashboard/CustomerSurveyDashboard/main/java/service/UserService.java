package service;

import UserDao;
import dto.User;

public class UserService {
	UserDao userDao = new UserDao();
	
	public User getUser(String username) {
		return userDao.getUserByUserName(username);
	}
}

