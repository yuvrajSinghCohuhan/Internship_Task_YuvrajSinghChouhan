package com.Project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Project.Dao.AppointmentDao;
import com.Project.Entities.Appointments;
import com.Project.Entities.User;

@Component
public class AppointmentService {
	@Autowired
	private AppointmentDao apdao;

	public List<Appointments> getAllAppointments() {
		List<Appointments> all = apdao.findAll();
		return all;
	}

	public Appointments getAppointmentsById(String appointment_id) {
		Optional<Appointments> op = apdao.findById(appointment_id);
		if(op.isPresent()) {
			Appointments ap = op.get();
			return ap;
		}
		return null;
	}

	public Appointments setAppointment(Appointments appointments) {
		if(appointments!=null) {
			Appointments save = apdao.save(appointments);
			return save;
		}
		return null;
	}

	public Appointments updateCancleAppointment(Appointments appointments, String appointment_id) {
		Optional<Appointments> byStatus = apdao.findById(appointment_id);
		if(byStatus.isPresent()) {
			Appointments ap = byStatus.get();
			appointments.setId(appointment_id);
			Appointments save = apdao.save(appointments);
			return save;
			}
		return null;
	}

	public Appointments updateRescheduleAppointment(Appointments appointments, String appointment_id) {
		Optional<Appointments> byStatus = apdao.findById(appointment_id);
		if(byStatus.isPresent()) {
			Appointments ap = byStatus.get();
			appointments.setId(appointment_id);
			Appointments save = apdao.save(appointments);
			return save;
			}
		return null;
	}


}
