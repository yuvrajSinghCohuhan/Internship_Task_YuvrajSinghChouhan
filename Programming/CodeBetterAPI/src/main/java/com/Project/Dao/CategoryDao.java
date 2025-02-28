package com.Project.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.Category;

public interface CategoryDao extends JpaRepository<Category, String> {

	void deleteById(String id);

	public List<Category> findByName(String name);

	public Optional<Category> findById(String id);

	void deleteAllById(String id);

}
