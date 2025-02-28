package com.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Project.Entities.Category;
import com.Project.Entities.SubCategory;
import com.Project.Entities.User;
import com.Project.service.CategoryService;
import com.Project.service.SubCategoryService;
import com.Project.service.UserService;

@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService catgoryService;

    @Autowired
    private SubCategoryService subService;

    // Login API
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User u) {
        Boolean b = userService.getUser(u);
        if (b) {
            return ResponseEntity.status(HttpStatus.OK).body("User logged in successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data");
        }
    }

    // Registration API
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User u) {
        if (u != null) {
            userService.addUser(u);
            return ResponseEntity.status(HttpStatus.OK).body("User registered successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user");
        }
    }

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
