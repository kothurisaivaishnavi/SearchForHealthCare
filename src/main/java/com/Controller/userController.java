package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.Dao.*;
import com.Health.*;
import com.Model.*;

@Controller
public class userController {
	@Autowired
	public userDao userdao;
	
	@RequestMapping(value ="/userhome")
	public String servicePage(user user,addService addservice,Model m) {
		return "userhome";
	}
	@RequestMapping("/search")    
    public String addservicepage(addService addservice,Model m){  
		 List<search> slist=userdao.search(addservice);
	      m.addAttribute("slist",slist); 
				return "search";
	}
	
	@ModelAttribute("SearchName")
	public List<String> SerName(){
		return userdao.searchname();
	}
	@ModelAttribute("SearchLocation")
	public List<String> Serlocation(){
		return userdao.searchlocation();
	}
	
	@RequestMapping("/address/{id}")    
    public String addresspage(@PathVariable int id,Model m){  
		search s=userdao.getAddById(id);
	      m.addAttribute("search",s); 
				return "address";
	}	
}
