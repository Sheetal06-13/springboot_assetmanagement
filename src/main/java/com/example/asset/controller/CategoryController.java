package com.example.asset.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.asset.entity.Category;
import com.example.asset.services.CategoryServices;


@RestController
public class CategoryController {
	 @Autowired
	    private CategoryServices categoryService;

	    // get all category handler
	    @GetMapping("/category")
	    public ResponseEntity<List<Category>> getcategorys() {

	        List<Category> list = categoryService.getAllcategorys();
	        if (list.size() <= 0) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.status(HttpStatus.CREATED).body(list);
	    }

	    
	    // new category handler
	    @PostMapping("/category")
	    public ResponseEntity<Category> addcategory(@RequestBody Category category) {
	        Category b = null;
	        try {
	            b = this.categoryService.addcategory(category);
	            System.out.println(category);
	            return ResponseEntity.status(HttpStatus.CREATED).build();
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }

	    }



	    // update category handler
	    @PutMapping("/categorys/{categoryId}")
	    public ResponseEntity<Category> updatecategory(@RequestBody Category category, @PathVariable("categoryId") int categoryId) {
	        try {
	            this.categoryService.updatecategory(category, categoryId);
	            return ResponseEntity.ok().body(category);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }

	       
	    }
}
