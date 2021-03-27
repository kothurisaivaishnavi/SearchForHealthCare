package com.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.Dao.*;
import com.Health.*;
import com.Model.*;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class serviceController {
	@Autowired
	public serviceDao servicedao;
	@RequestMapping(value ="/servicehome")
	public String servicePage(service service) {
		return "servicehome";
	}
	@RequestMapping("/addservicepage")    
    public String addservicepage(addService addservice,Model m){  
				return "AddService";
	}
	
	@ModelAttribute("SerName")
	public List<String> SerName(){
		return servicedao.sername();
	}
	@ModelAttribute("SerType")
	public List<String> SerType(){
		return servicedao.sertype();
	}
	
	@RequestMapping(value = "/Addservice/{username}", method = RequestMethod.POST)
	   public String addservice(@Valid @ModelAttribute("addService") addService addservice,BindingResult result,@PathVariable String username,ModelMap m) {
		if (result.hasErrors()) {
			return "AddService";
		}
		servicedao.addservice(addservice,username);
		m.put("msg","Your Service is Added Successfully");
	   return "servicehome";
	}
	
	@RequestMapping("/serviceProvided/{username}")    
    public String serviceProvided(@PathVariable String username,Model m){
       List<addService> list=servicedao.services(username);    
      m.addAttribute("list",list);  
        return "serviceProvided";    
    } 
	
	@RequestMapping("/update/{username}/{id}")    
    public String serviceProvidedupdate(@PathVariable String username,@PathVariable int id,ModelMap m){  
       addService addservice=servicedao.getSerById(id);
      m.addAttribute("addService",addservice); 
        return "AddServiceEditform";    
    } 
	
	@RequestMapping("/updated/{username}")    
	public String serviceProvidedupdated(@Valid @ModelAttribute("addService") addService addservice,BindingResult result,@PathVariable String username,ModelMap m) {
		if (result.hasErrors()) {
				return "AddServiceEditform";
			}
			servicedao.updated(addservice,username);
		   return "redirect:/serviceProvided/"+username;    
		}
	
	
	 @RequestMapping(value="/delete/{username}/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable String username,@PathVariable int id){    
	        servicedao.delete(id);    
	        return "redirect:/serviceProvided/"+username;    
	    }  
	
}
