package com.springboot_tiles.dao;

import com.springboot_tiles.to.UserTO;

public interface UserDAO {
	public UserTO getUser(String username); 
	public void addUser(UserTO tobpUser);
	public void addLoginUser(UserTO tobpUser);
	public void addLogoutUser(UserTO tobpUser);
}
