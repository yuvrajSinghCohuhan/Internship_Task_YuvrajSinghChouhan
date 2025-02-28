package com.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.CategoryDao;
import com.Project.Entities.Category;

@Component
public class CategoryService {
	@Autowired
	private CategoryDao cdao;

	public Category addCategory(Category c) {
		
		Category c1 = cdao.save(c);
		return c1;
	}

	public Category getCategory(String id) {
		Category ls= cdao.findById(id).get();
		return ls;
	}

	public List<Category> getCategories(String name) {
		List<Category>ls = cdao.findByName(name);
		return ls;
	}

	public List<Category> getAll() {
		List<Category>ls = cdao.findAll();
		return ls;
	}

	public Category updateCategoryById(Category c, String id) {
		Category c1 = cdao.findById(id).get();
		
		if(c1!=null) {
		c1.setName(c.getName());
		cdao.save(c1);
		return c1;
		}
		return null;
	}

	public void deleteCategoryById(String id) {
		cdao.deleteAllById(id);
	}

	public List<Category> addAllCategory(List<Category> c) {
		List<Category> ls = cdao.saveAll(c);
		return ls;
		
	}

}
