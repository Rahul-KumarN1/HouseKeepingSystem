package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Complaints;
import com.springboot.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	ComplaintRepository complaintRepository;

	@Override
	public void saveComplaint(Complaints complaint) {
		complaintRepository.save(complaint);
	}

	@Override
	public Complaints findComplaintById(int ticketId) {
		Complaints complaint = complaintRepository.findById(ticketId).orElse(null);
		return complaint;
	}

	@Override
	public void deleteComplaint(Complaints complaint) {
		complaintRepository.delete(complaint);
	}

	@Override
	public List<Complaints> findComplaintByEmail(String customerEmail) {
		return complaintRepository.findComplaintByCustomerEmail(customerEmail);
	}

	@Override
	public List<Complaints> getAllComplaints() {
		return (List<Complaints>) complaintRepository.findAll();
	}

}
