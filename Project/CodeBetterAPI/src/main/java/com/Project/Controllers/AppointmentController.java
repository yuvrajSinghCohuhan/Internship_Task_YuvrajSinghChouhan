package com.Project.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Appointments;
import com.Project.service.AppointmentService;

@RestController
@RequestMapping("/api")
public class AppointmentController {
	@Autowired
    private AppointmentService appointmentService;

    // Get all appointments
    @GetMapping("appointments")
    public ResponseEntity<List<Appointments>> getAllAppointments() {
        List<Appointments> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.status(HttpStatus.OK).body(appointments);
    }

    // Get appointment By Id
    @GetMapping("appointments/{appointment_id}")
    public ResponseEntity<Appointments> getAppointmentById(@PathVariable String appointment_id) {
        Appointments appointments = appointmentService.getAppointmentsById(appointment_id);
        return ResponseEntity.ok(appointments);
    }

    // Set appointments
    @PostMapping("appointments")
    public ResponseEntity<Map<String, Object>> setAppointment(@RequestBody Appointments appointments) {
    	if(appointments!=null) {
    		Appointments appointment = appointmentService.setAppointment(appointments);
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status", "success","message","Appointment set successfully","Appointment",appointment));
    	}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status", "error","message","Appointment set failed"));
    }
    
    //Update Cancelled Appointment
    @PutMapping("appointments/{appointment_id}/cancle")
    public ResponseEntity<Map<String, Object>> updateAppointmentByIdCancle(@PathVariable String appointment_id ,@RequestBody Appointments appointments) {
    	if(appointments!=null) {
    		Appointments appointment = appointmentService.updateCancleAppointment(appointments,appointment_id);
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status", "success","message","Appointment Cancelled successfully","Appointment",appointment));
    	}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status", "error","message","Appointment Cancel failed"));
    }
    
    //Update rescheduled Appointment
    @PutMapping("appointments/{appointment_id}/reschedule")
    public ResponseEntity<Map<String, Object>> updateAppointmentByIdReschedule(@PathVariable String appointment_id ,@RequestBody Appointments appointments) {
    	if(appointments!=null) {
    		Appointments appointment = appointmentService.updateRescheduleAppointment(appointments,appointment_id);
    		return ResponseEntity.status(HttpStatus.OK).body(Map.of("Status", "success","message","Appointment Rescheduled successfully","Appointment",appointment));
    	}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Status", "error","message","Appointment Update failed"));
    }
	
}
