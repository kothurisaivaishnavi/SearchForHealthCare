package com.Model;

import org.springframework.stereotype.Component;
import com.Controller.*;
import com.Dao.*;
import com.Health.*;

@Component
public class search {
	private String name;
    private long number;
    private String username ;
	  private int serviceId;
	  private String serviceName;
	  private String serviceType;
	  private String bussinessname;
	  private String address;
	  private String location;
	  private String medicalStore;
	  private String ambulance;
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
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
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
	
	public String getBussinessname() {
		return bussinessname;
	}
	public void setBussinessname(String bussinessname) {
		this.bussinessname = bussinessname;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	  
}
