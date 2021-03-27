package com.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.Dao.*;
import com.Model.*;

@Controller
public class registerController {
	@Autowired
	public registerDao registerdao;
	@RequestMapping(value ="/userregisterpage")
	public String userregisterPage(user user) {
		return "userregister";
	}
	
	@RequestMapping(value ="/adminregisterpage")
	public String adminregisterPage(login login) {
		return "adminregister";
	}
	@RequestMapping(value ="/serviceregisterpage")
	public String serviceregisterPage(service service) {
		return "serviceregister";
	}
	
	   
	   @RequestMapping(value = "/adminregister", method = RequestMethod.POST)
		public String adminregister(@Valid @ModelAttribute("login") login login, BindingResult result, ModelMap map) {
		   if (result.hasErrors()) {
				return "adminregister";
			}
		   if(registerdao.check(login.getUsername(),"admin")) {
			int i=registerdao.adminregister(login);
			if(i==1)
				map.addAttribute("msg", "Your Details are Submitted Successfully");
		   return"login";
		   }
		   else {
			   map.put("avail", "Username is Not Available");
			   return "adminregister";   
			   }
	}
	   @RequestMapping(value = "/userregister", method = RequestMethod.POST)
	   public String userregister(@Valid @ModelAttribute("user") user user,login login,BindingResult result, ModelMap map){
		   if (result.hasErrors()) {
			   return "userregister";
		   }
		   
		   if(registerdao.check(user.getUsername(),"user")) {
		   int i=registerdao.userregister(user);
		   if(i==1)
			   map.put("msg", "Your Details are Submitted Successfully");
		     return "login";
		   }
		   else {
			   map.put("avail", "Username is Not Available");
			   return "userregister";   
			   }
		   
	   }
	   @RequestMapping(value = "/serviceregister", method = RequestMethod.POST)
		public String serviceregister(@Valid @ModelAttribute("service") service service,login login,BindingResult result, ModelMap map) {
		   if (result.hasErrors()) {
				return "serviceregister";
			}
		   if(registerdao.check(service.getUsername(),"service")) {
			   int i=registerdao.serviceregister(service);
				if(i==1)
					map.put("msg", "Your Details are Submitted Successfully");
				return"login";
		   }
		   else {
			   map.put("avail", "Username is Not Available");
			   return "serviceregister";   
		   }
	}
	
}
