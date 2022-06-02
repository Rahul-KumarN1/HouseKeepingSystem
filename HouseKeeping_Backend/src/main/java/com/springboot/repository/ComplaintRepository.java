package com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Complaints;

@Repository
public interface ComplaintRepository extends CrudRepository<Complaints, Integer> {

	List<Complaints> findComplaintByCustomerEmail(String customerEmail);

	List<Complaints> findComplaintByPincode(String managerPincode);

}
