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

import com.springboot.model.Customers;

import com.springboot.service.CustomerService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/getAllCustomers")
	public List<Customers> getAllCustomers() {
		List<Customers> customers = (List<Customers>) customerService.fetchAllCustomers();
		return customers;
	}

	@PostMapping("/login")
	public Boolean validateCustomer(@RequestBody Customers loginDetails) throws NoSuchFieldException {

		String customerEmail = loginDetails.getCustomerEmail();
		String customerPassword = loginDetails.getCustomerPassword();

		System.out.println(customerEmail + " " + customerPassword);

		Boolean customerLoginStatus = customerService.validateCustomer(customerEmail, customerPassword);
		return customerLoginStatus;
	}

	@PostMapping("/addCustomer")
	public boolean addCustomer(@RequestBody Customers customer) {
		return customerService.saveCustomer(customer);
	}

	@DeleteMapping("/deleteCustomer/{customerEmail}")
	public void deleteCustomer(@PathVariable("customerEmail") String email) {
		Customers customer = customerService.findCustomerById(email);
		customerService.deleteCustomer(customer);

	}

	@PutMapping("/updateCustomer/{customerEmail}")
	public boolean updateManager(@PathVariable("customerEmail") String email, @RequestBody String newPincode) {
		System.out.println(newPincode + "----------");
		Customers customer = customerService.findCustomerById(email);
		customer.setCustomerPincode(newPincode);
		customerService.saveCustomer(customer);

		return true;
	}

}
