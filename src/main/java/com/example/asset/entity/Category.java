package com.example.asset.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="category")

public class Category {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="description")
    private String description;
	
	@OneToOne(fetch= FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="asset_id")
    private Asset asset;
	
	public long getId() {
		return id;
	}
	public Category() {
		
	}
	public Category(long id, String name, String description, Asset asset) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.asset = asset;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
}
