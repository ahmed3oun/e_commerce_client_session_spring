package com.project.e_pharmacie_spring_client.services;

import java.util.List;

import com.project.e_pharmacie_spring_client.models.Category;
import com.project.e_pharmacie_spring_client.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<Category> listAllCategories() {
        return repository.findAll();
    }

    public void save(Category category) {
        repository.save(category);
    }

    public Category getCategoryById(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}