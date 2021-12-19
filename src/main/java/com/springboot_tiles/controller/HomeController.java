package com.springboot_tiles.controller;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot_tiles.service.SecurityService;

@Controller
@RequestMapping("home*")
public class HomeController {
	@Autowired SecurityService securityService;
	
	@GetMapping()
	public String index(Authentication authentication,Model model) {
	 	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addAttribute("username", userDetail.getUsername());
		return "home.index";
	}

	@GetMapping("getData")
	public ResponseEntity<?> getDataHome(){
		JSONObject obj = new JSONObject();
		
		obj.put("status", HttpServletResponse.SC_OK);
		
		obj.put("message", "ini data response");
		return ResponseEntity.ok(obj.toString());
	}
}
