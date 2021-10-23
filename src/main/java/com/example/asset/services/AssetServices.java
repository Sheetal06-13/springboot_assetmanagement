package com.example.asset.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.asset.entity.Asset;
import com.example.asset.repository.AssetRepository;

@Component
public class AssetServices {
	@Autowired
    private AssetRepository assetRepository;
   
    // get all Asset 
    public List<Asset> getAllBooks() {
        List<Asset> list=(List<Asset>)this.assetRepository.findAll();
        return list;
    }

    // get single Asset  by id
    public Asset getAssetById(int id) {
    	Asset asset = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        	asset=this.assetRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asset;
    }

    // adding the asset
    public Asset addAsset(Asset b) {
    	Asset result=assetRepository.save(b);
        return result;
    }

    // delete asset
    public void deleteAsset(int bid) {
        // list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());

    	assetRepository.deleteById(bid);
    }

    // update the Asset 
    public void updateAsset(Asset asset , int assetId) {
        

    	asset.setId(assetId);
    	assetRepository.save(asset);
    }
}
