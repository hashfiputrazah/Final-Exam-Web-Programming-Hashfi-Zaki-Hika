package com.springboot_tiles.to;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class UserTO  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long UserID;
    private String firstName;
    private String lastName;
    private String FullName;
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getCurrent_login() {
		return current_login;
	}
	public void setCurrent_login(String current_login) {
		this.current_login = current_login;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getOperating_system() {
		return operating_system;
	}
	public void setOperating_system(String operating_system) {
		this.operating_system = operating_system;
	}
	public Set<UserRoleTO> getRoles() {
		return roles;
	}
	public void setRoles(Set<UserRoleTO> roles) {
		this.roles = roles;
	}
	private String username;
    private String password;
    private String passwordConfirm;
    private String current_login;
    private String last_login;
    private String ip_address;
    private String browser;
    private String operating_system;
    private Set<UserRoleTO> roles;
	public Long getUserID() {
		return UserID;
	}
	public void setUserID(Long userID) {
		UserID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
}
