package com.springboot_tiles.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.springboot_tiles.service.UserService;
import com.springboot_tiles.to.UserTO;
import com.springboot_tiles.util.ZClientInfo;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired 
	private UserService userService;
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
    	// run custom logics upon successful login
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        System.out.println("Login Successfully. User " + username + " has logged in.");
      
        UserTO tobpUser = new UserTO();
        tobpUser.setUsername(username);
        tobpUser.setIp_address(ZClientInfo.getClientIpAddr(request));
        tobpUser.setBrowser(ZClientInfo.getClientBrowser(request));
        tobpUser.setOperating_system(ZClientInfo.getClientOS(request));
        userService.addLoginUser(tobpUser);
        super.onAuthenticationSuccess(request, response, authentication);
    }
 
}
