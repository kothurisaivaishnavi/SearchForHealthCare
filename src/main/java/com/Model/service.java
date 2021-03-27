package com.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import com.Controller.*;
import com.Dao.*;
import com.Health.*;

@Component
public class service {
	@NotBlank(message="Name Field cannot be Empty")
	@Size(min = 5, max=20,message = "Username should be atleast 5 Characters and max 20 characters")
	private String name;
	private long number;
	@NotBlank(message = "UserName cannot be empty")
	private String username;
	@NotBlank(message = "Password cannot be empty")
    @Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", message="password should contain one Uppercse, Lowercase, numbers and special character")
    @Size(min=6, message="Minimum 6 Characters")
	private String password;
	@NotBlank(message="Service Location Field cannot be Empty")
	private String location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
