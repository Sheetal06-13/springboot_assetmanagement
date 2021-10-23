package com.example.asset.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="asset")
public class Asset {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="purchase_date")
	private LocalDate purchase_date;
	
	@Column(name="condition_notes")
	private String condition_notes;
	
	@Enumerated(EnumType.STRING)
	@Column(name="assignment_status")
	private Assignment_status assignment_status;
	
	@OneToOne(fetch= FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="asset")
	private Category category;
	
	public Asset() {
		
	}
	public Asset(long id, String name, LocalDate purchase_date, String condition_notes,
			Assignment_status assignment_status) {
		super();
		this.id = id;
		this.name = name;
		this.purchase_date = purchase_date;
		this.condition_notes = condition_notes;
		this.assignment_status = assignment_status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(LocalDate purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getCondition_notes() {
		return condition_notes;
	}
	public void setCondition_notes(String condition_notes) {
		this.condition_notes = condition_notes;
	}
	public Assignment_status getAssignment_status() {
		return assignment_status;
	}
	public void setAssignment_status(Assignment_status assignment_status) {
		this.assignment_status = assignment_status;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	
}
