package com.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.Controller.*;
import com.Health.*;
import com.Model.*;

@Repository
public class userDao {
	@Autowired(required = true)
	JdbcTemplate template;
	String x;
	String y;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<String> searchname(){    
	    return template.queryForList("select distinct serviceName from addservice",String.class); 
	} 
	
	public List<String> searchlocation(){    
	    return template.queryForList("select distinct location from addservice",String.class);
	}
	
	public List<search> search(addService addservice){    
		if(addservice.getServiceName().equals("all")) {
			x=" is not null ";
		}
		else {
			x="='"+addservice.getServiceName()+"' ";
		}
		if(addservice.getLocation().equals("all")) {
			y=" is not null ";
		}
		else {
			y="='"+addservice.getLocation()+"' ";
		}
		
		String sql="select s.name,s.number,s.username,a.serviceId,a.serviceName,a.serviceType,a.name,a.address,a.location,a.medicalStore,a.ambulance from service as s inner join addservice as a On s.username=a.username where a.serviceName"+x+"and a.location"+y+"and a.medicalStore='"+addservice.getMedicalStore()+"' and a.ambulance='"+addservice.getAmbulance()+"';";
	    
		return template.query(sql,new RowMapper<search>() {  
	        public search mapRow(ResultSet rs,  int row)throws SQLException {    
	        	search s=new search();
	        	s.setName(rs.getString(1)); 
	        	s.setNumber(rs.getLong(2));
	        	s.setUsername(rs.getString(3)); 
	            s.setServiceId(rs.getInt(4));    
	            s.setServiceName(rs.getString(5));    
	            s.setServiceType(rs.getString(6));    
	            s.setBussinessname(rs.getString(7));
	            s.setAddress(rs.getString(8));
	            s.setLocation(rs.getString(9));
	            s.setMedicalStore(rs.getString(10));
	            s.setAmbulance(rs.getString(11));
	            return s;    
	        }    
	    }); 
	}
	
	public search getAddById(int id){  
		String sql="select s.name,s.number,s.username,a.serviceId,a.serviceName,a.serviceType,a.name as bussinessname,a.address,a.location,a.medicalStore,a.ambulance from service as s inner join addservice as a on s.username=a.username where ServiceId=?;";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<search>(search.class)); 
	} 
	
}
