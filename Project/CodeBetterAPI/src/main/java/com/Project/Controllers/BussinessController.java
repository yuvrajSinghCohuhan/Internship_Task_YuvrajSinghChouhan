package com.Project.Controllers;

import java.util.Map;
import java.util.Optional;

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

import com.Project.Entities.Bussiness;
import com.Project.service.BussinessService;

@RestController
@RequestMapping("/bussiness")
public class BussinessController {
	@Autowired
	private BussinessService bussinessService;
	
	// 4.1 Register a new business
    @PostMapping("/register/{userId}")
    public ResponseEntity<Map<String, Object>> registerBusiness(@PathVariable String userId,@RequestBody Bussiness bussiness) {
        try {
            Bussiness createdBusiness = bussinessService.registerBusiness(userId,bussiness);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("status", "success", "message", "bussiness Created successfully","bussiness", createdBusiness));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    // 4.2 Get business details
    @GetMapping("/{business_id}")
    public ResponseEntity<Map<String, Object>> getBusiness(@PathVariable String business_id) {
        Optional<Bussiness> business = bussinessService.getBusinessById(business_id);
        if (business.isPresent()) {
            return ResponseEntity.ok(Map.of("status", "success", "business", business.get(), "status_code", 200));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", "Business not found"));
    }

    // 4.3 Update business details
    @PutMapping("/{business_id}")
    public ResponseEntity<Map<String, Object>> updateBusiness(@PathVariable String business_id, @RequestBody Bussiness updatedBusiness) {
        try {
            Bussiness business = bussinessService.updateBusiness(business_id, updatedBusiness);
            return ResponseEntity.ok(Map.of("status", "success", "message", "Business updated successfully", "business", business));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    // 4.4 Delete business
    @DeleteMapping("/{business_id}")
    public ResponseEntity<Map<String, Object>> deleteBusiness(@PathVariable String business_id) {
        if (bussinessService.deleteBusiness(business_id)) {
            return ResponseEntity.ok(Map.of("status", "success", "message", "Business removed successfully", "status_code", 200));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", "Business not found"));
    }

}
