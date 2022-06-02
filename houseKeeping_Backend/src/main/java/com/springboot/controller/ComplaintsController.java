package com.springboot.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Complaints;
import com.springboot.service.ComplaintService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(path = "/complaints")
public class ComplaintsController {

	@Autowired
	ComplaintService complaintService;

	@GetMapping("/getAllComplaints")
	public List<Complaints> getAllComplaints() {
		List<Complaints> complaints = (List<Complaints>) complaintService.getAllComplaints();
		return complaints;
	}

	@GetMapping("/getAllComplaintsByEmail/{customerEmail}")
	public List<Complaints> getAllComplaintsByEmail(@PathVariable("customerEmail") String customerEmail) {
		System.out.println("inside complaints controller -- " + customerEmail);

		List<Complaints> complaints = (List<Complaints>) complaintService.findComplaintByEmail(customerEmail);
		return (List<Complaints>) complaints;
	}

	@PostMapping("/getAllComplaintsByTicketIds")
	public List<Complaints> getAllComplaintsByTicketIds(@RequestBody int[] ticketIds) {

		System.out.println("ticket Ids from Backend -- " + ticketIds);
		List<Complaints> complaints = new ArrayList<Complaints>();
		for (int i = 0; i < ticketIds.length; i++) {
			System.out.println(ticketIds[i]);
			complaints.add(complaintService.findComplaintById(ticketIds[i]));
		}
		return (List<Complaints>) complaints;

	}

	@GetMapping("/getComplaintById/{ticketId}")
	public Complaints getComplaintById(@PathVariable("ticketId") int ticketId) {
		Complaints complaint = complaintService.findComplaintById(ticketId);
		return complaint;
	}

	@PostMapping("/addComplaint")
	public @ResponseBody void addComplaint(@RequestBody Complaints complaint) {
		complaintService.saveComplaint(complaint);

	}

	@DeleteMapping("/deleteComplaintById/{ticketId}")
	public void deleteComplaintById(@PathVariable("ticketId") int ticketId) {
		Complaints complaint = complaintService.findComplaintById(ticketId);
		complaintService.deleteComplaint(complaint);

	}

	@PutMapping("/updateComplaint")
	public boolean updateComplaint(@RequestBody Complaints complaint) {
		System.out.println(complaint.getTicketId() + "-------");
		Complaints existingComplaint = complaintService.findComplaintById(complaint.getTicketId());
		existingComplaint.setComplaint(complaint.getComplaint());
		existingComplaint.setCustomerEmail(complaint.getCustomerEmail());
		existingComplaint.setPincode(complaint.getPincode());
		existingComplaint.setStatus(complaint.getStatus());
		complaintService.saveComplaint(existingComplaint);

		return true;
	}

}
