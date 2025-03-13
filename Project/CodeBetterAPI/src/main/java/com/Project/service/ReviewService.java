package com.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.ReviewDao;
import com.Project.Entities.Reviews;

@Component
public class ReviewService {
	@Autowired
	private ReviewDao rdao;

	public Reviews getReview(String id) {
		try {
			Reviews ls = rdao.findById(id).get();
			return ls;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Reviews updateReview(String id, Reviews r) {
		Optional<Reviews> op = rdao.findById(id);
		if(op.isPresent()) {
			Reviews r1 = op.get();
			System.out.println(r1);
			r.setId(r1.getId());
			Reviews save = rdao.save(r);
			return save;
		}
		return null;
	}

	public boolean deleteReview(String id) {
		if(id!=null) {
		rdao.deleteById(id);
		return true;
		}
		return false;
		
	}

}
