package com.Project.Entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

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
public class Bussiness {
	@Id
	@Column(name = "business_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User userId;
	@Column(name = "business_name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "contact_info")
	private String mobile;
	@Column(name = "logo_url")
	private String logo;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false) // Prevent updates to created_at
	private Date created_at;

	public Bussiness() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Bussiness(User userId, String name, String address, String mobile, String logo, Date created_at) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.logo = logo;
		this.created_at = created_at;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Business [id=" + id + ", userId=" + userId + ", name=" + name + ", address=" + address + ", mobile="
				+ mobile + ", logo=" + logo + ", created_at=" + created_at + "]";
	}

}
