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
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "review_id")
	private String id;

	@ManyToOne
	@JoinColumn(name = "service_id", referencedColumnName = "service_id")
	private Services service_id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user_id;

	private double rating;
	private String comment;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false) // Prevent updates to created_at
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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


	public Services getService_id() {
		return service_id;
	}


	public void setService_id(Services service_id) {
		this.service_id = service_id;
	}


	public User getUser_id() {
		return user_id;
	}


	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}


	


	public Reviews(String id, Services service_id, User user_id, double rating, String comment, Date created_at,
			Date updated_at) {
		super();
		this.id = id;
		this.service_id = service_id;
		this.user_id = user_id;
		this.rating = rating;
		this.comment = comment;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	@Override
	public String toString() {
		return "Reviews [service_id=" + service_id + ", user_id=" + user_id + ", rating=" + rating + ", comment="
				+ comment + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

	

}
