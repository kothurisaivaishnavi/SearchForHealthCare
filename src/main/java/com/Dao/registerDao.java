package com.Dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Controller.*;
import com.Health.*;
import com.Model.*;

@Repository
public class registerDao {

	@Autowired(required=true)
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	@ExceptionHandler(SQLException.class)
	public int userregister(user u){    
		//System.out.println(u.getFirstname()+u.getLastname()+u.getAge()+u.getGender()+u.getNumber()+u.getUsername()+u.getPassword());
	    String sql="insert into user values(?,?,?,?,?,?,?,?)";  
	   return template.update(sql,u.getFirstname(),u.getLastname(),u.getDob(),u.getGender(),u.getNumber(),u.getUsername(),u.getPassword(),u.getAddress());    
	} 
	
	public int adminregister(login u){    
		//System.out.println(u.getFirstname()+u.getLastname()+u.getAge()+u.getGender()+u.getNumber()+u.getUsername()+u.getPassword());
	    String sql="insert into admin values(?,?,?)";  
	   return template.update(sql,u.getUsername(),u.getPassword(),u.getName());    
	} 
	public int serviceregister(service u){    
		//System.out.println(u.getFirstname()+u.getLastname()+u.getAge()+u.getGender()+u.getNumber()+u.getUsername()+u.getPassword());
	    String sql="insert into service values(?,?,?,?,?,false)";  
	   return template.update(sql,u.getName(),u.getNumber(),u.getUsername(),u.getPassword(),u.getLocation());    
	} 
	
	public boolean check(String username, String table) {
		String Q = "select count(*) from "+ table +" where username=?";
		int i =template.queryForObject(Q,new Object[] { username},Integer.class);
		if (i == 0) {

			return true;
		}
		return false;
	}
}
