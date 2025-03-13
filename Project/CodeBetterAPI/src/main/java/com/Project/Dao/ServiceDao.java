package com.Project.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.Services;

public interface ServiceDao extends JpaRepository<Services, String> {
	
}
