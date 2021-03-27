package com.Model;

//import java.util.Date;
import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class user {
     @NotBlank(message="Firstname Cannot be Empty")
     @Size(min = 5, max=20,message = "Username should be atleast 5 Characters and max 20 characters")
	private String firstname;
     @NotBlank(message="Lastname Cannot be Empty")
     @Size(min = 3, max=20,message = "Username should be atleast 3 Characters and max 20 characters")
	private String lastname;
    //@Past(message="Enter the correct Date of Birth")
	private Date dob;
     @NotBlank(message="select your gender")
	private String gender;
   // @Pattern(regexp="[6-7]{1}[0-9]{9}",message="Enter correct mobile number it should start with(6,7,8,9)")
	private long number;
     @NotBlank(message = "UserName cannot be empty")
	private String username;
     @NotBlank(message = "Password cannot be empty")
     @Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", message="password should contain one Uppercse, Lowercase, numbers and special character")
     @Size(min=6, message="Minimum 6 Characters")
	private String password;
     @NotBlank(message="Enter your Address here")
     private String address;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
