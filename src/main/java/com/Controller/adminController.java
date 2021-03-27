package com.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import com.Dao.*;
import com.Health.*;
import com.Model.*;


@Controller
public class adminController {
	@Autowired
	public adminDao admindao;
	@RequestMapping(value ="/adminhome")
	public String adminPage(login login) {
		return "adminhome";
	}
	@RequestMapping("/approve")    
    public String approve(Model m){    
        List<service> list=admindao.Approve();    
        m.addAttribute("list",list);  
        return "approve";    
    }  
	
	 @RequestMapping(value="/approve/{username}")    
	    public String edit(@PathVariable String username, Model m){    
	       admindao.approved(username);    
	        return "redirect:/approve";    
	    }  
	 @RequestMapping(value="/delete/{username}")    
	    public String delete(@PathVariable String username){    
	        admindao.delete(username);    
	        return "redirect:/approve";    
	    }  
	 @RequestMapping(value ="/addservicecategories")
		public String addServiceCategories(serviceCategories servicecategories) {
			return "AddServiceCategories";
	 }
	 @RequestMapping(value="/serviceCategories", method = RequestMethod.POST)    
	    public String serviceCategories(@Valid @ModelAttribute("serviceCategories") serviceCategories servicecategories,BindingResult result, ModelMap map){    
		if (result.hasErrors()) {
				return "AddServiceCategories";
			}  
		    admindao.addservicecateories(servicecategories);
		    map.put("msg","Service Category is Added Successfully");
	        return "adminhome";    
	    }  
	 
	 @RequestMapping("/categoriesProvided")    
	    public String categoriesProvided(Model m){
	       List<serviceCategories> list=admindao.categories();    
	      m.addAttribute("list",list);  
	        return "categoriesProvided";    
	    } 
	 
		
		@RequestMapping("/update/{id}")    
	    public String categoriesupdate(@PathVariable int id,ModelMap m){  
	       serviceCategories servicecategories=admindao.getcatById(id);
	      m.addAttribute("serviceCategories",servicecategories); 
	        return "AddServiceCategoriesEditform";    
	    } 
		
		
		@RequestMapping("/updated")    
		public String categoriesupdated(@Valid @ModelAttribute("serviceCategories") serviceCategories servicecategories,BindingResult result,ModelMap m) {
			if (result.hasErrors()) {
				return "AddServiceCategoriesEditform";
			}   
			admindao.updated(servicecategories);
			   return "redirect:/categoriesProvided";    
		}
		
	 
	 @RequestMapping(value="/deletecat/{id}",method = RequestMethod.GET)    
	    public String deletecat(@PathVariable int id){    
	        admindao.deletecat(id);    
	        return "redirect:/categoriesProvided";    
	    }  
	 
}
