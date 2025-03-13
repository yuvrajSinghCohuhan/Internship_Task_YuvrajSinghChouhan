package com.Project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.BussinessDao;
import com.Project.Dao.UserDao;
import com.Project.Entities.Bussiness;
import com.Project.Entities.User;

@Component
public class BussinessService {
	@Autowired
	private BussinessDao bdao;
	@Autowired
	private UserDao udao;

	public Bussiness registerBusiness(String userId, Bussiness bussiness) {
		 Optional<User> op= udao.findById(userId);
		 if(op.isPresent()) {
			 User u = op.get(); 
			 bussiness.setUserId(u);
		 Bussiness bussiness2= bdao.save(bussiness);
		 if(bussiness2!=null) {
			 return bussiness2;
		 }
		 }
		 return null;
	}

	public Optional<Bussiness> getBusinessById(String business_id) {
		Optional<Bussiness>op = bdao.findById(business_id);
		return op;
	}

	public Bussiness updateBusiness(String business_id, Bussiness updatedBusiness) {
		Optional<Bussiness>op = bdao.findById(business_id);
		if(op.isPresent()) {
			Bussiness bussiness = op.get();
			updatedBusiness.setId(bussiness.getId());
			Bussiness save = bdao.save(updatedBusiness);
			return save;
		}
		return null;
	}

	public boolean deleteBusiness(String business_id) {
		if(business_id.length()!=0) {
			bdao.deleteById(business_id);
			return true;
		}
		return false;
	}
	
	

}
