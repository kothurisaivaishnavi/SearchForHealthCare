package com.Dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Controller.*;
import com.Health.*;
import com.Model.*;

@Repository
public class loginDao {
	@Autowired(required = true)
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public boolean adminlogin(String username, String password) {
		String Q = "select count(*) from admin where username=? and password=?";
	//login log = template.queryForObject(Q, new Object[] { username, password },new RowMapper<login>());
		//String Q="select count(*) from admin where username='"+username+"' and password='"+password+"';";
	int i =template.queryForObject(Q,new Object[] { username, password },Integer.class);
		if (i!= 0) {
			return true;
		}
		return false;
	}

	public boolean userlogin(String username, String password) {
		String Q = "select count(*) from user where username=? and password=?";
		int i =template.queryForObject(Q,new Object[] { username, password },Integer.class);
		if (i != 0) {

			return true;
		}
		return false;
	}

	public boolean servicelogin(String username, String password) {
		String Q = "select count(*) from service where username=? and password=?";
		int i =template.queryForObject(Q,new Object[] { username, password },Integer.class);
		if (i != 0) {

			return true;
		}
		return false;
	}
	
	public boolean approve(String username, String password) {
		String Q = "select status from service where username=? and password=?";
		return template.queryForObject(Q,new Object[] { username, password },Boolean.class);
	}
}
