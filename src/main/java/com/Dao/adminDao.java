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
public class adminDao {
	@Autowired(required = true)
	JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	public List<service> Approve(){    
	    return template.query("select * from service where status=false",new RowMapper<service>(){  
	        public service mapRow(ResultSet rs,  int row)throws SQLException {    
	            service s=new service();    
	            s.setName(rs.getString(1));    
	            s.setNumber(rs.getLong(2));    
	            s.setUsername(rs.getString(3));    
	            s.setPassword(rs.getString(4));
	            s.setLocation(rs.getString(5));
	            return s;    
	        }    
	    });    
	} 
	
	public int approved(String username){    
	    String sql="update service set status=true where username='"+username+"';";    
	    return template.update(sql);
	    
	} 

	public int delete(String username){    
	    String sql="delete from service where username='"+username+"';";    
	    return template.update(sql);    
	}    
	
	public int addservicecateories(serviceCategories u) {
		  String sql="insert into servicecategories values(?,?,?)";  
		   return template.update(sql,u.getServiceId(),u.getServiceName(),u.getServiceType());
	}
	
	public List<serviceCategories> categories(){    
	    return template.query("select * from servicecategories order by serviceType;",new RowMapper<serviceCategories>() {  
	        public serviceCategories mapRow(ResultSet rs,  int row)throws SQLException {    
	        	serviceCategories s=new serviceCategories();
	            s.setServiceId(rs.getInt(1));    
	            s.setServiceName(rs.getString(2));    
	            s.setServiceType(rs.getString(3));    
	            return s;    
	        }    
	    }); 
	}
	
	public serviceCategories getcatById(int id){  
	    String sql="select serviceId,serviceName,serviceType from servicecategories where serviceId=?;";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<serviceCategories>(serviceCategories.class));    
	} 
	
	public int updated(serviceCategories p){    
	    String sql="update servicecategories set serviceId='"+p.getServiceId()+"', serviceName='"+p.getServiceName()+"', serviceType='"+p.getServiceType()+"' where serviceId='"+p.getServiceId()+"';";    
	    return template.update(sql);    
	} 
	
	public int deletecat(int id){    
	    String sql="delete from servicecategories where serviceId='"+id+"';";    
	    return template.update(sql);    
	} 
}
