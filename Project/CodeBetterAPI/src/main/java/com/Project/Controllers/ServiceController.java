package com.Project.Controllers;

import java.util.List;
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

import com.Project.Entities.Services;
import com.Project.service.ServiceBL;

@RestController
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private ServiceBL serviceBl;

	//Add services
    @PostMapping
    public ResponseEntity<Map<String, Object>> addService(@RequestBody Services services){
    	try {
    		if(services!=null) {
    			Services s = serviceBl.addService(services);
    			return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status", "success", "message", "Service Added successfully", "Service", s));
    		}
			
		} catch (Exception e) {
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status", "error", "message", "Service Add failed", "Service", e.getMessage()));
		}
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status", "error", "message", "Service Add failed"));
    }
    
    //Get All Services
    @GetMapping
    public ResponseEntity<Map<String, Object>> showServices(){
    	List<Services>services = serviceBl.getAllServices();
    	if(services.size()!=0) {
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status", "success", "message", "Service Added successfully", "Service", services));
    	}
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status", "error", "message", "Services Not Found"));
    }
    //Get All Services
    @GetMapping("/{serviceId}")
    public ResponseEntity<Map<String, Object>> showServiceById(@PathVariable String serviceId){
    	Optional<Services> services = serviceBl.getServicesById(serviceId);
    	if(services.isPresent()) {
    		Services s = services.get();
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status", "success", "message", "Service Added successfully", "Service", s));
    	}
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status", "error", "message", "Services Not Found"));
    }
    
    //Update Services
    @PutMapping("/{serviceId}")
    public ResponseEntity<Map<String, Object>> updateService(@RequestBody Services services,@PathVariable String serviceId){
    	if(services!=null) {
    	Services updateService = serviceBl.updateService(serviceId,services);
    	if(updateService!=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status", "success", "message", "Service Updated successfully", "Service", updateService));
    	}
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Status", "error", "message", "Service Not Found to update"));
    }
    //Delete Service
    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Map<String, Object>> deleteService(@PathVariable String serviceId){
    	boolean b = serviceBl.deleteService(serviceId);
    	if(b) {
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status", "success", "message", "Service Delete successfully"));
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Status", "error", "message", "Service Not Found to update"));
    }
}
