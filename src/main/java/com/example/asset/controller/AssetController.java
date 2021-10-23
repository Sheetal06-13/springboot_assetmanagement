package com.example.asset.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.asset.entity.Asset;
import com.example.asset.services.AssetServices;

@RestController
public class AssetController {
	 @Autowired
	    private AssetServices assetService;

	    // get all Asset 
	    @GetMapping("/asset")
	    public ResponseEntity<List<Asset>> getAsset() {

	        List<Asset> list = assetService.getAllBooks();
	        if (list.size() <= 0) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.status(HttpStatus.CREATED).body(list);
	    }

	    // get Asset 
	    @GetMapping("/asset/{id}")
	    public ResponseEntity<Asset> getAsset(@PathVariable("id") int id) {
	    	Asset asset = assetService.getAssetById(id);
	        if (asset == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.of(Optional.of(asset));
	    }

	    // new Asset 
	    @PostMapping("/assets")
	    public ResponseEntity<Asset> addAsset(@RequestBody Asset asset) {
	    	Asset b = null;
	        try {
	            b = this.assetService.addAsset(asset);
	            System.out.println(asset);
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }

	    }

	    // delete Asset 

	    @DeleteMapping("/asset/{assetId}")
	    public ResponseEntity<Void> deleteAsset(@PathVariable("assetId") int assetId) {
	        try {
	            this.assetService.deleteAsset(assetId);
	            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }

	    }

	    // update Asset
	    @PutMapping("/asset/{assetId}")
	    public ResponseEntity<Asset> updateAsset(@RequestBody Asset asset, @PathVariable("assetId") int assetId) {
	        try {
	            this.assetService.updateAsset(asset, assetId);
	            return ResponseEntity.ok().body(asset);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }

	       
	    }

}
