package com.springboot_tiles.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot_tiles.service.BookManagementService;
import com.springboot_tiles.service.SecurityService;
import com.springboot_tiles.service.UserService;
import com.springboot_tiles.to.Book_ManagementTO;
import com.springboot_tiles.to.UserTO;
import com.springboot_tiles.util.ZUtility;
import com.springboot_tiles.validator.UserValidator;

@Controller
public class IndexController {
	@Autowired UserService userService;
	@Autowired UserValidator userValidator;
	@Autowired SecurityService securityService;
	@Autowired BookManagementService bookservice;
	@Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/login")
    public String login(Model model, String error, String logout, HttpServletRequest request) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("messagex", "You have been logged out successfully.");

        return "login";
    }
	
	@GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserTO());

        return "registration";
    }
	
	@PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserTO userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        UserTO tobpUser = new UserTO();
        tobpUser.setUsername(userForm.getUsername());
        tobpUser.setFirstName(userForm.getFirstName());
        tobpUser.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        userService.addUser(tobpUser);
        
       /* indexSerive.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());*/

        return "redirect:/";
    }
	
	@GetMapping({"/"})
    public String welcome(Model model, HttpServletRequest request) {
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();	
	        model.addAttribute("username", userDetail.getUsername());
			return "redirect:/home";
		}else {
			return "login";
		}
    }
	
	@PostMapping({"/"})
	public String login_process(Model model, String error, String logout, HttpServletRequest request) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	
    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserTO tobpUser = new UserTO();
        tobpUser.setUsername(auth.getName());
        userService.addLogoutUser(tobpUser);
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
        System.out.println("Logout Successfully.");
    	return "redirect:/login?logout";  
     }  
    
    //for 403 access denied page
    @GetMapping("/403")
    public String accesssDenied(Model model) {

    	//check if user is login
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (!(auth instanceof AnonymousAuthenticationToken)) {
    		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
    		model.addAttribute("username", userDetail.getUsername());
    	}
      
    	return "/error/error_403";
    }
  
    @GetMapping("/session")
    public @ResponseBody String doGetSession(HttpServletRequest request, HttpServletResponse response) {
    	String strResult = "";
		//check if user is login
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (!(auth instanceof AnonymousAuthenticationToken)) {
    		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
    		strResult = ZUtility.SESS_USER_ID + userDetail.toString();
    	}else {
    		strResult = ZUtility.SESS_TIMEOUT;
    	}
		
		return strResult;
    }
    
    
    //Book Management
    @GetMapping("/get_Book")
	public @ResponseBody String getLLD_Code(HttpServletRequest request) throws JsonProcessingException{
		String result = "";
		try {
			List<Book_ManagementTO> tobBook_Management = bookservice.getBook();
			 result = new ObjectMapper().writeValueAsString(tobBook_Management);
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

}
