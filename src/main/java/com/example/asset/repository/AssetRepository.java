package com.example.asset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.asset.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long>{
	public Asset findById(int id);

	public void deleteById(int bid);   
}