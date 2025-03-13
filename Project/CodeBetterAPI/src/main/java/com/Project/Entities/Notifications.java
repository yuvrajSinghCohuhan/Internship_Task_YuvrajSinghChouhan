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
public class Notifications {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;


    @Column(nullable = false)
    private String message;

    @Column(name = "is_read", nullable = false)
    private boolean read;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;

    public Notifications() {}

    public Notifications(User user, String message, boolean read) {
        this.user = user;
        this.message = message;
        this.read = read;
    }

    public String getId() {
        return id;
    }

    public User getUser() {  // Renamed from getUserId()
        return user;
    }

    public void setUser(User user) {  // Renamed from setUserId()
        this.user = user;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Notifications [userId=" + user + ", message=" + message + ", read=" + read + ", createdAt=" + createdAt + "]";
    }
	
	

}
