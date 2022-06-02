package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Managers;

@Repository
public interface ManagerRepository extends CrudRepository<Managers, String> {

}
