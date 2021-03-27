package com.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Dao.*;
import com.Model.*;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
@Controller
public class loginController{
	@Autowired
	public loginDao logindao;
	
	@RequestMapping(value ="/loginpage")
	public String loginPage(login login) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") login login,HttpSession session, ModelMap m) {
		if (login.getType().equals("admin")) {
			boolean log = logindao.adminlogin(login.getUsername(), login.getPassword());
			if (log){
				session.setAttribute("username",login.getUsername());
				return "adminhome";
			}
			else {
				m.put("msg", "Invalid Login Credentials");
				return "login";
			}
		}

		else if (login.getType().equals("user")) {
			boolean log = logindao.userlogin(login.getUsername(), login.getPassword());
			if (log) {
				session.setAttribute("username",login.getUsername());
				return "redirect:/userhome";
			}
			else {
				m.put("msg", "Invalid Login Credentials");
				return "login";
			}
		} else {
			 boolean log= logindao.servicelogin(login.getUsername(),login.getPassword());
			if(log) {
				boolean approve=logindao.approve(login.getUsername(),login.getPassword());
				if(approve) {
					session.setAttribute("username",login.getUsername());
					return "servicehome";
				}
				else{
					m.put("msg", "Approval pending with Admin");
					return "login";
				}
			}
			else{
				m.put("msg", "Invalid Login Credentials");
				return "login";
			}

		}
	}
	@RequestMapping(value="/logout/{username}")
	public String logout(HttpSession session,@PathVariable String username,ModelMap m) {
		session.removeAttribute(username);
		return "redirect:/loginpage";
	}
	
@RequestMapping(value="/Welcome")
public String welcome() {
	//m.addAttribute("command", new login());
	return "Welcome";
}
}
