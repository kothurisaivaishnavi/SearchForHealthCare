package com.Health;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.Controller.*;
import com.Dao.*;
import com.Model.*;

import org.springframework.stereotype.Component;

@Component
public class serviceCategories {
	/*
	 * @NotBlank(message="Service Id field cannot be Empty")
	 * 
	 * @Size(min=5,message="the minimum size of service Id is 5")
	 */
private int serviceId;
@NotBlank(message="Service Name field cannot be Empty")
@Size(min = 5, max=20,message = "Service name should be atleast 5 Characters and max 20 characters")
private String serviceName;
@NotBlank(message="Service Type field cannot be Empty")
@Size(min = 5, max=20,message = "Service Type should be atleast 5 Characters and max 20 characters")
private String serviceType;
public int getServiceId() {
	return serviceId;
}
public void setServiceId(int i) {
	this.serviceId = i;
}
public String getServiceName() {
	return serviceName;
}
public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}
public String getServiceType() {
	return serviceType;
}
public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
}

}
