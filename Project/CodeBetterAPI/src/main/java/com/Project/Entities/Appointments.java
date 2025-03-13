package com.Project.Entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Appointments {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "appointment_id")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "service_id",referencedColumnName = "service_id")
	private Services service;
	
	@ManyToOne
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	private User user;
	
	@Column(name = "appointment_date")
	private Date appointmentDate;
	
	
	private String status;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false) // Prevent updates to created_at
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	public Appointments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointments(Services sid, User uid, Date appointmentDate, String status, Date created_at, Date updated_at) {
		super();
		this.service = sid;
		this.user = uid;
		this.appointmentDate = appointmentDate;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Services getSid() {
		return service;
	}

	public void setSid(Services sid) {
		this.service = sid;
	}

	public User getUid() {
		return user;
	}

	public void setUid(User uid) {
		this.user = uid;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "Appointments [id=" + id + ", sid=" + service + ", uid=" + user + ", appointmentDate=" + appointmentDate
				+ ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	


    
    
    
}
