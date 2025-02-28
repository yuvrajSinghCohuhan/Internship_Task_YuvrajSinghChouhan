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

import com.Project.Dao.CategoryDao;
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
	
	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody User u) {
		Boolean b =  userService.getUser(u);
		if (b==true) {
	        return ResponseEntity.status(HttpStatus.OK).body("User Loged in successfully!");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data");
	    }
	}
	
	@PostMapping("register")
	public ResponseEntity<String> registeration(@RequestBody User u) {
	    if (u != null) {
	        userService.addUser(u);
	        return ResponseEntity.status(HttpStatus.OK).body("User registered successfully!");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user");
	    }
	}
	
	@PostMapping("categories")
	public ResponseEntity<String> category(@RequestBody Category c) {
	    if (c != null) {
	        catgoryService.addCategory(c);
	        return ResponseEntity.status(HttpStatus.OK).body("User registered successfully!");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user");
	    }
	}
	// get All Categories
	@GetMapping("categories")
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> ls = catgoryService.getAll();
		if(ls.size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(ls);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	//get Category by ID
	@GetMapping("category/{id}")
	public ResponseEntity<Category> category(@PathVariable int id){
		Category c = catgoryService.getCategories(id);
		if(c!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	// get Category by name
	@GetMapping("categories/{name}")
	public ResponseEntity<List<Category>> category(@PathVariable String name){
		List<Category> ls = catgoryService.getCategories(name);
		if(ls.size()!=0) {
			return ResponseEntity.status(HttpStatus.FOUND).body(ls);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	//update Category by Id
	@PutMapping("category/{id}")
	public ResponseEntity<Category> updateById(@RequestBody Category c ,@PathVariable String id){
		Category c1 = catgoryService.updateCategoryById(c,id);
		if(c1!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(c1);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	//Delete Category by Id
		@DeleteMapping("category/{id}")
		public ResponseEntity<String> deleteById(@PathVariable String id){
			if(id!=null) {
				catgoryService.deleteCategoryById(id);
				return ResponseEntity.status(HttpStatus.OK).body("Deleted");
			}
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	// API for Sub-Category

		@PostMapping("subcategories")
		public ResponseEntity<List<SubCategory>> addMulSubCategory(@RequestBody List<SubCategory> sc) {

			if (sc != null) {
				List<SubCategory> list = subService.addSubCategory(sc);
				return ResponseEntity.status(HttpStatus.CREATED).body(list);

			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}


		@PostMapping("categories/{id}/subcategories")
		public ResponseEntity<SubCategory> getSubcategory(@RequestBody SubCategory sc, @PathVariable String id)

		{

			if (sc != null) {
				SubCategory s = subService.addSubcategoryById(sc, id);
				return ResponseEntity.status(HttpStatus.CREATED).body(sc);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

//		==================================================================================================
		// GET API FOR SUB CATEGORY

		@GetMapping("categories/{id}/subcategories")
		public ResponseEntity<List<SubCategory>> getSubcategoryByCategory(@PathVariable String id) {
			List<SubCategory> ls = subService.getSubcategoryByCategory(id)
	;
			if (!ls.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(ls);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		// ===============================================================================================================

		// Put API FOR Update Sub-Category

		@PutMapping("subcategories/{id}")
		public ResponseEntity<SubCategory> UpdateBySubCategoryId(@RequestBody SubCategory sc, @PathVariable String id) {
			if (sc != null && id != null) {
				subService.UpdateBySubCategoryId(id, sc);
				return ResponseEntity.status(HttpStatus.OK).body(sc);
			}

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		//=================================================================================================

		
		@DeleteMapping("subcategories/{id}")
		public ResponseEntity<String> deleteSubcategoryById(@PathVariable String categoryId) {
		    try {
		        subService.deleteSubcategoryById(categoryId);
		        return ResponseEntity.status(HttpStatus.OK).body("SubCategory deleted successfully.");
		    } catch (RuntimeException e) {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		    }
	
	
		}
 }
