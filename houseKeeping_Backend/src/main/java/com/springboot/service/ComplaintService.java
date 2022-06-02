package com.springboot.service;

import java.util.List;

import com.springboot.model.Complaints;

public interface ComplaintService {

	void saveComplaint(Complaints complaint);

	Complaints findComplaintById(int ticketId);

	void deleteComplaint(Complaints complaint);

	List<Complaints> findComplaintByEmail(String customerEmail);

	List<Complaints> getAllComplaints();

}
