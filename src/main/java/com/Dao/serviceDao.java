package com.Dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.Health.*;



@Repository
public class serviceDao {
	@Autowired(required = true)
	JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<String> sername(){    
	    return template.queryForList("select distinct serviceName from servicecategories",String.class); 
	} 
	
	public List<String> sertype(){    
	    return template.queryForList("select distinct serviceType from servicecategories",String.class);
	}
	public int addservice(addService u,String user){    
	    String sql="insert into addService values(?,?,?,?,?,?,?,?,?)";  
	   return template.update(sql,user,u.getServiceId(),u.getServiceName(),u.getServiceType(),u.getName(),u.getAddress(),u.getLocation(),u.getMedicalStore(),u.getAmbulance());    
	} 
	
	public List<addService> services(String username){    
	    return template.query("select * from addservice where username='"+username+"';",new RowMapper<addService>() {  
	        public addService mapRow(ResultSet rs,  int row)throws SQLException {    
	            addService s=new addService();
	            s.setServiceId(rs.getString(2));    
	            s.setServiceName(rs.getString(3));    
	            s.setServiceType(rs.getString(4));    
	            s.setName(rs.getString(5));
	            s.setAddress(rs.getString(6));
	            s.setLocation(rs.getString(7));
	            s.setMedicalStore(rs.getString(8));
	            s.setAmbulance(rs.getString(9));
	            return s;    
	        }    
	    }); 
	}
	public addService getSerById(int id){  
	    String sql="select serviceId,serviceName,serviceType,name,address,location,medicalStore,ambulance from addservice where ServiceId=?;";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<addService>(addService.class));    
	} 
	
	public int updated(addService p,String user){    
	    String sql="update addService set serviceName='"+p.getServiceName()+"', serviceType='"+p.getServiceType()+"',name='"+p.getName()+"',address='"+p.getAddress()+"',location='"+p.getLocation()+"',medicalStore='"+p.getMedicalStore()+"',ambulance='"+p.getAmbulance()+"' where serviceId='"+p.getServiceId()+"'and username='"+user+"';";    
	    return template.update(sql);    
	} 
	
	public int delete(int id){    
	    String sql="delete from addservice where ServiceId="+id+";";    
	    return template.update(sql);    
	} 
}

