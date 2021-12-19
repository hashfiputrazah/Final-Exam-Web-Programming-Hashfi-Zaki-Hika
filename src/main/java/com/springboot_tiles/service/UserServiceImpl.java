package com.springboot_tiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot_tiles.dao.UserDAO;
import com.springboot_tiles.to.UserTO;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO dao;

	@Override
	public UserTO getUser(String username) {
		return dao.getUser(username);
	}

	@Override
	public void addUser(UserTO tobpUser) {
		dao.addUser(tobpUser);
	}

	@Override
	public void addLoginUser(UserTO tobpUser) {
		dao.addLoginUser(tobpUser);
	}

	@Override
	public void addLogoutUser(UserTO tobpUser) {
		dao.addLogoutUser(tobpUser);
	}

}
