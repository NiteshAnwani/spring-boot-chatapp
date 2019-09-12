package com.training.chatapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.training.chatapp.model.User;
import com.training.chatapp.repository.UserRepository;

@Controller
public class AccountController extends WebMvcConfigurerAdapter {

	@Autowired
	UserRepository u;
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/login").setViewName("shared_template/login");
	        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    }
	
	
	
	/*
	 * @RequestMapping(value="/login",method = RequestMethod.GET) private String
	 * login(Model m,String error,String logout) {
	 * 
	 * if(error!=null) { m.addAttribute("error", "Error in login"+error); }
	 * if(logout!=null) { m.addAttribute("logout", "log out"); }
	 * 
	 * return "shared_template/login"; }
	 */
	@RequestMapping(value="/register",method = RequestMethod.GET)
	private String registeration(@ModelAttribute("User") User user) {
		user.setActive(1);
		
		return "shared_template/register";
	}
	
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(Model m){ 
		List<User> user=u.findAll();
		m.addAttribute("user", user);
		m.addAttribute("test", "testing");
        return "index";  
    }  
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String homt(){  
        return "shared_template/home";  
    }  
	
	
}
