package com.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.Controller.*;
import com.Dao.*;
import com.Health.*;

import org.springframework.stereotype.Component;

@Component
public class login {
@NotBlank(message = "UserName cannot be empty")
@Size(min = 5, max=20,message = "Username should me atleast 5 Characters and max 20 characters")
private String username;
@NotBlank(message = "Password cannot be empty")
@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}", message="password should contain one Uppercse, Lowercase, numbers and special character")
@Size(min=6, message="Minimum 6 Characters")
private String password;
private String type;
@NotBlank(message="Name cannot be empty")
private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

}
