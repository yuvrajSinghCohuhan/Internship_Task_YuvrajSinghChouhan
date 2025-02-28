package com.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.CategoryDao;
import com.Project.Dao.SubCategoryRepository;
import com.Project.Entities.Category;
import com.Project.Entities.SubCategory;

@Component
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository sr;

    @Autowired
    private CategoryDao cr;

    public List<SubCategory> addSubCategory(List<SubCategory> sc) {
        return sr.saveAll(sc);
    }

    public SubCategory addSubcategoryById(SubCategory sc, String id) {
        Optional<Category> categoryOptional = cr.findById(id);
        if (categoryOptional.isPresent()) {
            sc.setCategory(categoryOptional.get());
            return sr.save(sc);
        } else {
            throw new RuntimeException("Category with ID " + id + " not found.");
        }
    }

    public List<SubCategory> getSubcategoryByCategory(String id) {
        return sr.findByCategoryId(id);
    }

    public void UpdateBySubCategoryId(String id, SubCategory sc) {
        Optional<SubCategory> op = sr.findById(id);
        if (op.isPresent()) {
            SubCategory existingSubCategory = op.get();
            existingSubCategory.setSubcategoryName(sc.getSubcategoryName());
            sr.save(existingSubCategory);
        }
    }

    public void deleteSubcategoryById(String id) {
        sr.deleteById(id);
    }

    public void deleteCategoryById(String categoryId) {
        sr.deleteByCategoryId(categoryId); 
        cr.deleteById(categoryId); 
    }
}
