package com.springboot_tiles.service;

import com.springboot_tiles.to.UserTO;


public interface UserService {
	public UserTO getUser(String username); 
	public void addUser(UserTO tobpUser);
	public void addLoginUser(UserTO tobpUser);
	public void addLogoutUser(UserTO tobpUser);
}
