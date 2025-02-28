package com.Project.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Entities.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, String>  {

	public Optional findById(String id);

	public List<SubCategory> findByCategoryId(String id);

	public void deleteByCategoryId(String categoryId);
	

}
