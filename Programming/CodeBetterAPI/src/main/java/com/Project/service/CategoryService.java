package com.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.CategoryDao;
import com.Project.Entities.Category;

@Component
public class CategoryService {
	@Autowired
	private CategoryDao cdao;

	public void addCategory(Category c) {
		cdao.save(c);
	}

	public Category getCategories(int id) {
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
		Category c1 = cdao.findById(id);
		if(c1!=null) {
		c1.setC_name(c.getC_name());
		cdao.save(c1);
		return c1;
		}
		return null;
	}

	public void deleteCategoryById(String id) {
		cdao.deleteAllById(id);
	}

}
