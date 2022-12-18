package com.Jforce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Jforce.model.User;
import com.Jforce.service.UserService;

@Controller

public class UserController {
	
	@Autowired
	private UserService us;
	
	
	
	//registration
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register form";
		
	}
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		this.us.register(user);
		return "redirect:";
	}

}
