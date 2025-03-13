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
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "payment_id")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "appointment_id",referencedColumnName = "appointment_id")
	private Appointments appointment_id;
	
	
	private double amount;
	@Column(name = "paymentMethod")
	private String paymentMethod;
	
	@Column(name = "status")
	private String status;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false) // Prevent updates to created_at
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payments(Appointments appointment_id, double amount, String paymentMethod, Date created_at, Date updated_at) {
		super();
		this.appointment_id = appointment_id;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getCreated_at() {
		return created_at;
	}

	@Override
	public String toString() {
		return "Payments [appointment_id=" + appointment_id + ", amount=" + amount + ", paymentMethod=" + paymentMethod
				+ ", status=" + status + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	

	public Appointments getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(Appointments appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	


}
