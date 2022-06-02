package com.springboot.service;

import java.util.List;

import com.springboot.model.Complaints;
import com.springboot.model.Managers;

public interface ManagerService {

	void saveManager(Managers manager);

	Managers findManagerById(String email);

	void deleteManager(Managers manager);

	Boolean validateManager(String managerEmail, String managerPassword);
	
	List<Complaints> findComplaintByPincode(String managerPincode);
	
	List<Managers> getAllManagers();
	
}
