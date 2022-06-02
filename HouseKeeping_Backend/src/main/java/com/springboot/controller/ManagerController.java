package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Complaints;
import com.springboot.model.Managers;
import com.springboot.service.ManagerService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(path = "/managers")
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@GetMapping("/getAllManagers")
	public List<Managers> getAllManagers() {
		List<Managers> managers = (List<Managers>) managerService.getAllManagers();
		return managers;
	}

	@GetMapping("/getManager/{email}")
	public Managers getManagerById(@PathVariable String email) {
		return managerService.findManagerById(email);
	}

	@PostMapping("/addManager")
	public void addManager(@RequestBody Managers manager) {
		managerService.saveManager(manager);

	}

	@PostMapping("/login")
	public Managers validateManager(@RequestBody Managers loginDetails) throws NoSuchFieldException {

		String managerEmail = loginDetails.getManagerEmail();
		String managerPassword = loginDetails.getManagerPassword();

		Boolean managerLoginStatus = managerService.validateManager(managerEmail, managerPassword);
		if (managerLoginStatus) {

			Managers manager = managerService.findManagerById(managerEmail);
			return manager;
		}
		return null;
	}

	@GetMapping("/getAllComplaintsByPincode/{managerPincode}")
	public List<Complaints> getAllComplaintsByPincode(@PathVariable("managerPincode") String managerPincode) {
		System.out.println("inside managers controller -- " + managerPincode);

		List<Complaints> complaints = (List<Complaints>) managerService.findComplaintByPincode(managerPincode);
		return (List<Complaints>) complaints;
	}

	@DeleteMapping("/deleteManager/{managerEmail}")
	public void deleteManager(@PathVariable("managerEmail") String email) {
		Managers manager = managerService.findManagerById(email);
		managerService.deleteManager(manager);

	}

	@PutMapping("/updateManager/{managerEmail}")
	public boolean updateManager(@PathVariable("managerEmail") String email, @RequestBody String newPincode) {
		System.out.println(newPincode + "----------");
		Managers manager = managerService.findManagerById(email);
		manager.setManagerPincode(newPincode);
		managerService.saveManager(manager);
		return true;

	}

}
