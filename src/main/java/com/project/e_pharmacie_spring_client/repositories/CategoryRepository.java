package com.project.e_pharmacie_spring_client.repositories;

import com.project.e_pharmacie_spring_client.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}