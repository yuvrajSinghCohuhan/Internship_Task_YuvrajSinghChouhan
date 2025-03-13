package com.Project.Entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subcategory_id")
    private String id;

    @Column(name = "subcategory_name")
    private String subcategoryName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false) // Prevent updates to created_at
    private Date created_at;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    @JsonBackReference
    private Category category;

    public SubCategory() {
        super();
    }

    public SubCategory(String subcategoryName, Date created_at, Date updated_at, Category category) {
        super();
        this.subcategoryName = subcategoryName;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SubCategory [id=" + id + ", subcategoryName=" + subcategoryName + ", created_at=" + created_at
                + ", updated_at=" + updated_at + ", category=" + category + "]";
    }
}
