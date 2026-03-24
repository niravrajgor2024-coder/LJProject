package com.design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.design.entity.User;
import com.design.service.UserService;


import jakarta.validation.Valid;

@Controller
public class WebController {
	   
		public UserService userService;
		public WebController(UserService userService){
			this.userService=userService;
		}
		@GetMapping("/register")
		public String showRegisterForm(Model model){
			model.addAttribute("user",new User());
			return "auth/register";			
		}		
		@PostMapping("/saveUser")		
public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result){		
			if(result.hasErrors()){					
				return "auth/register";
			}
			userService.saveUsers(user);
			return "auth/success"; 
		}	
		@GetMapping("/login")
		private String display2(){
			return "auth/login";			
		}		
		@GetMapping("/display")
		private String show_users(Model model){
			model.addAttribute("listUsers", userService.getAllUsersList());
			return "showRecords";			
		}		
		@GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable Long id, Model model) {
	        model.addAttribute("user", userService.getUserById(id));
	        return "update_user";
	    }		
		@GetMapping("/deleteUser/{id}")
	    public String deleteStudent(@PathVariable Long id) {
			userService.deleteUser(id);
	        return "redirect:/";
	    }				
}
