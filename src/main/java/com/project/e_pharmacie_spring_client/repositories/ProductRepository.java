package com.project.e_pharmacie_spring_client.repositories;

import com.project.e_pharmacie_spring_client.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer>,ProductRepositoryCustom {
    
}