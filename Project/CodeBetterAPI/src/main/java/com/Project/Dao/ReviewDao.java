package com.Project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.Reviews;

public interface ReviewDao extends JpaRepository<Reviews, String> {
	

}
