package com.Project.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Reviews;
import com.Project.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getReview(@PathVariable String id){
		Reviews allReview = reviewService.getReview(id);
		if(allReview!=null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status","success", "message","Review submitted successfully","status_code", "201" ,"review",allReview));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status","error"));
	}
	
	
	// not working..............
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Object>> updateReview(@RequestBody Reviews r,@PathVariable String id){
		System.out.println(r);// it give null values.............
		if(r!=null && r.getCreated_at()!=null) {
		Reviews allReview = reviewService.updateReview(id,r);
		if(allReview!=null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status","success", "message","Review submitted successfully","status_code", "201" ,"review",allReview));
		}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status","error"));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteReview(@PathVariable String id){
		if(id.length()!=0) {
			boolean deleteReview = reviewService.deleteReview(id);
			if(deleteReview) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status","success", "message","Review submitted successfully","status_code", "201"));
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status","error"));
	}

}
