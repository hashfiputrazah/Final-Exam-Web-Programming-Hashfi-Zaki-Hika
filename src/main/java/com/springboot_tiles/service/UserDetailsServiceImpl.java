package com.springboot_tiles.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot_tiles.dao.UserDAO;
import com.springboot_tiles.to.UserRoleTO;
import com.springboot_tiles.to.UserTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserDAO dao;

    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserTO user = dao.getUser(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserRoleTO role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
