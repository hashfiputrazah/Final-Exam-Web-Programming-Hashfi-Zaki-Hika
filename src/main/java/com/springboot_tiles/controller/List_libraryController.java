package com.springboot_tiles.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("list_library*")
public class List_libraryController {
	@GetMapping()
	public String index(Authentication authentication,Model model) {
	 	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addAttribute("username", userDetail.getUsername());
	
		return "library_management.list_library";
	}
}
