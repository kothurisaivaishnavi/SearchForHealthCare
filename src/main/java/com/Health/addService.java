package com.Health;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


@Component
public class addService {
  @NotBlank(message="Name field Cannot be Empty")
  @Size(min = 3, max=20,message = "ServiceID  should be atleast 3 Characters and max 20 characters")
  private String serviceId;
  private String serviceName;
  private String serviceType;
  @NotBlank(message="Name field Cannot be Empty")
  @Size(min = 5, max=20,message = "Company Name should be atleast 5 Characters and max 20 characters")
  private String name;
  @NotBlank(message="Enter the Area Address that you provide Service")
  @Size(min = 5, max=20,message = "Address should be atleast 5 Characters and max 20 characters")
  private String address;
  @NotBlank(message="Enter the Location here")
  @Size(min = 5, max=20,message = "Location should be atleast 5 Characters and max 20 characters")
  private String location;
  private String medicalStore;
  private String ambulance;
  
  public String getServiceId() {
	return serviceId;
}
public void setServiceId(String serviceId) {
	this.serviceId = serviceId;
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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getMedicalStore() {
	return medicalStore;
}
public void setMedicalStore(String medicalStore) {
	this.medicalStore = medicalStore;
}
public String getAmbulance() {
	return ambulance;
}
public void setAmbulance(String ambulance) {
	this.ambulance = ambulance;
}

}
