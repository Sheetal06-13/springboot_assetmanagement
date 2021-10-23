package com.example.asset.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.asset.entity.Category;
import com.example.asset.repository.CategoryRepository;


@Component
public class CategoryServices {
	@Autowired
    private CategoryRepository categoryRepository;
    // get all category
    public List<Category> getAllcategorys() {
        List<Category> list=(List<Category>)this.categoryRepository.findAll();
        return list;
    }

    
    // adding the category
    public Category addcategory(Category b) {
        Category result=categoryRepository.save(b);
        return result;
    }

   

    // update the category
    public void updatecategory(Category category, int categoryId) {

        category.setId(categoryId);
        categoryRepository.save(category);
    }
}
