package com.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Category;
import com.Project.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
    private CategoryService catgoryService;
    
    // Add Category
    @PostMapping("categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category c) {
        if (c != null) {
            Category c1 = catgoryService.addCategory(c);
            return ResponseEntity.status(HttpStatus.CREATED).body(c1);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Add list of categories
    @PostMapping("categories/list")
    public ResponseEntity<List<Category>> addCategories(@RequestBody List<Category> c) {
        if (c != null && !c.isEmpty()) {
            List<Category> ls = catgoryService.addAllCategory(c);
            return ResponseEntity.status(HttpStatus.CREATED).body(ls);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Get all Categories
    @GetMapping("categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> ls = catgoryService.getAll();
        if (!ls.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(ls);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Get Category by ID
    @GetMapping("category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        Category c = catgoryService.getCategory(id);
        if (c != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Get Categories by name
    @GetMapping("categories/{name}")
    public ResponseEntity<List<Category>> getCategoriesByName(@PathVariable String name) {
        List<Category> ls = catgoryService.getCategories(name);
        if (!ls.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(ls);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Update Category by Id
    @PutMapping("category/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category c, @PathVariable String id) {
        Category updatedCategory = catgoryService.updateCategoryById(c, id);
        if (updatedCategory != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Delete Category by Id
    @DeleteMapping("category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable String id) {
        if (id != null) {
            catgoryService.deleteCategoryById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
