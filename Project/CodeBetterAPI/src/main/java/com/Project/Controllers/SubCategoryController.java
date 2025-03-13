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

import com.Project.Entities.SubCategory;
import com.Project.service.SubCategoryService;

@RestController
@RequestMapping("/subcategory")
public class SubCategoryController {
	
    @Autowired
    private SubCategoryService subService;
    
    // Add Sub-Categories
    @PostMapping("subcategories")
    public ResponseEntity<List<SubCategory>> addSubCategories(@RequestBody List<SubCategory> sc) {
        if (sc != null && !sc.isEmpty()) {
            List<SubCategory> list = subService.addSubCategory(sc);
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Add Sub-Category to Category
    @PostMapping("categories/{id}/subcategories")
    public ResponseEntity<SubCategory> addSubcategoryToCategory(@RequestBody SubCategory sc, @PathVariable String id) {
        if (sc != null) {
            SubCategory addedSubCategory = subService.addSubcategoryById(sc, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedSubCategory);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // Get Subcategories by Category ID
    @GetMapping("categories/{id}/subcategories")
    public ResponseEntity<List<SubCategory>> getSubcategoriesByCategory(@PathVariable String id) {
        List<SubCategory> ls = subService.getSubcategoryByCategory(id);
        if (!ls.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(ls);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Update Subcategory by Id
    @PutMapping("subcategories/{id}")
    public ResponseEntity<SubCategory> updateSubcategoryById(@RequestBody SubCategory sc, @PathVariable String id) {
        subService.UpdateBySubCategoryId(id, sc);
        return ResponseEntity.status(HttpStatus.OK).body(sc);
    }

    // Delete Subcategory by Id
    @DeleteMapping("subcategories/{id}")
    public ResponseEntity<String> deleteSubcategoryById(@PathVariable String id) {
        try {
            subService.deleteSubcategoryById(id);
            return ResponseEntity.status(HttpStatus.OK).body("SubCategory deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}

