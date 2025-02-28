package com.Project.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	void deleteById(String id);

	public List<Category> findByName(String name);

	public Category findById(String id);

	void deleteAllById(String id);

}
