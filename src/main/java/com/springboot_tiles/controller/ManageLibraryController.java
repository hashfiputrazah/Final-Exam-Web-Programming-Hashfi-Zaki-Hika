package com.springboot_tiles.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot_tiles.service.BookManagementService;
import com.springboot_tiles.to.Book_ManagementTO;
import com.springboot_tiles.to.UserTO;
import com.springboot_tiles.util.ZUtility;


@Controller
@RequestMapping("manage_library*")
public class ManageLibraryController {
	@Autowired BookManagementService bookservice;
	@GetMapping()
	public String index(Authentication authentication,Model model,HttpServletRequest request) {
	  	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addAttribute("username", userDetail.getUsername());
		System.out.println("user"+userDetail.getUsername());
		return "library_management.manage_library";
	}
	  @PostMapping("/update_Book")
		public @ResponseBody String update(HttpServletRequest request,
				@RequestParam("data") String data) {
			String strResult = null;
			  ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println("data"+data);
				mapper.setSerializationInclusion(Include.NON_NULL);
				Book_ManagementTO tobBook_Management = mapper.readValue(data, Book_ManagementTO.class);
				strResult = bookservice.Update(tobBook_Management);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return strResult;
		}
	  @PostMapping("/insert_Book")
			public @ResponseBody String insert(HttpServletRequest request,
					@RequestParam("data") String data) {
				String strResult = null;
				  ObjectMapper mapper = new ObjectMapper();
				try {
					System.out.println("data"+data);
					mapper.setSerializationInclusion(Include.NON_NULL);
					Book_ManagementTO tobBook_Management = mapper.readValue(data, Book_ManagementTO.class);
					strResult = bookservice.Insert(tobBook_Management);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return strResult;
			}
	  
	  @PostMapping("/delete_Book")
		public @ResponseBody String delete(HttpServletRequest request,
				@RequestParam("data") int data) {
			String strResult = null;
			  ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println("data"+data);
				mapper.setSerializationInclusion(Include.NON_NULL);
//				Book_ManagementTO tobBook_Management = mapper.readValue(data, Book_ManagementTO.class);
				strResult = bookservice.Delete(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return strResult;
		}
}
