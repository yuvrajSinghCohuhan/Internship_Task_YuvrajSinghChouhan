package com.Project.Controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Payments;
import com.Project.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentsController {
	
	@Autowired
	private PaymentService paymentService;
	
	// 8.1 Initiate Payment
    @PostMapping("/initiate")
    public ResponseEntity<Map<String, Object>> initiatePayment(@RequestBody Payments p) {
    	if(p!=null) {
    		paymentService.AddPayment(p);
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "success", "message", "Payment initiation successful","Payment",p));
    	}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", "Payment Failed"));
    }
    
    @GetMapping
    public ResponseEntity<List<Payments>> getPayment() {
    		List<Payments> payment = paymentService.getPayment();
    		if(payment.size()!=0) {	
    		return ResponseEntity.status(HttpStatus.OK).body(payment);
    		}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } 
    
//    @PutMapping("/{payment_id}")
//    public ResponseEntity<Map<String, Object>> updatePayment(@PathVariable String paymentId,@RequestBody Payments p) {
//    	if(p!=null&&paymentId.length()!=0) {
//    		paymentService.AddPayment(p);
//    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "success", "message", "Payment initiation successful","Payment",p));
//    	}
//    	
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", "Payment Failed"));
//    }
    
    @GetMapping("verify/{id}")
    public ResponseEntity<Map<String, Object>> verifyPayment(@PathVariable String id) {
    		Payments payment = paymentService.verifyPayment(id);
    		if(payment!=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("status","success", "payment_status", payment.getStatus(), "status_code", "200","payment",payment));
    		}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @GetMapping("refund/{id}")
    public ResponseEntity<Map<String, Object>> refundPayment(@PathVariable String id) {
    		Payments payment = paymentService.refundPayment(id);
    		if(payment.getStatus().equalsIgnoreCase("Refunded")) {
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("status","success",  "message", "Refund processed successfully", "status_code", "200","payment",payment));
    		}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
