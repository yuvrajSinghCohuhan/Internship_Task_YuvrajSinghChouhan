package com.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.ServiceDao;
import com.Project.Entities.Services;

@Component
public class ServiceBL {
	@Autowired
	private ServiceDao sdao;

	public Services addService(Services services) {
		Services s = sdao.save(services);
		return s;
	}

	public List<Services> getAllServices() {
		List<Services> ls = sdao.findAll();
		return ls;
	}

	public Services updateService(String serviceId, Services services) {
		Optional<Services> op = sdao.findById(serviceId);
		System.out.println(services);
		if(op.isPresent()) {
			Services s = op.get();
			Services save = sdao.save(services);
			return save;
		}
		return null;
	}

	public boolean deleteService(String serviceId) {
		if(serviceId.length()!= 0) {
			sdao.deleteById(serviceId);
			return true;
		}
		return false;
	}

	public Optional<Services> getServicesById(String serviceId) {
		Optional<Services> service = sdao.findById(serviceId);
		return service;
	}
	

}
