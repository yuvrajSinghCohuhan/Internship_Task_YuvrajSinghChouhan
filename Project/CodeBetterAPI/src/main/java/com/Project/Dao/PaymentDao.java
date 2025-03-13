package com.Project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.Payments;

public interface PaymentDao extends JpaRepository<Payments, String>{
	

}
