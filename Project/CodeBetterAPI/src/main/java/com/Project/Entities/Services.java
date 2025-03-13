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
public class Services {
	@Id
	@Column(name = "service_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@ManyToOne
	@JoinColumn(name = "subcategory_id", referencedColumnName = "subcategory_id")
	private SubCategory subId;

	@ManyToOne
	@JoinColumn(name = "business_id", referencedColumnName = "business_id")
	private Bussiness bid;

	@Column(name = "service_name")
	private String name;

	@Column(name = "description")
	private String description;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false) // Prevent updates to created_at
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;

	public Services(SubCategory subId, Bussiness bid, String name, String description, Date created_at,
			Date updated_at) {
		super();
		this.subId = subId;
		this.bid = bid;
		this.name = name;
		this.description = description;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SubCategory getSubId() {
		return subId;
	}

	public void setSubId(SubCategory subId) {
		this.subId = subId;
	}

	public Bussiness getBid() {
		return bid;
	}

	public void setBid(Bussiness bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Service [id=" + id + ", subId=" + subId + ", bid=" + bid + ", name=" + name + ", description="
				+ description + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}


}
