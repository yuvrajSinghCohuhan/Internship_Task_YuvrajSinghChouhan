package com.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.PaymentDao;
import com.Project.Entities.Payments;

@Component
public class PaymentService {
	@Autowired
	private PaymentDao pdao;


    // Initiate Payment
    public Payments initiatePayment(String appointmentId, Double amount, String paymentMethod) {
       
        return null;
    }


	public Payments AddPayment(Payments p) {
		Payments p1 = pdao.save(p);
		return p1;
	}


	public List<Payments> getPayment() {
		List<Payments> ls = pdao.findAll();
		return ls;
	}


	public Payments verifyPayment(String id) {
		Optional<Payments> op = pdao.findById(id);
		if(op.isPresent()) {
			Payments p = op.get();
			return p;
		}
		return null;
	}


	public Payments refundPayment(String id) {
		Optional<Payments> op = pdao.findById(id);
		if(op.isPresent()) {
			Payments p = op.get();
			return p;
		}
		return null;
	}


}
