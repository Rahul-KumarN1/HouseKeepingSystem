package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Feedbacks;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedbacks, Integer> {

}
