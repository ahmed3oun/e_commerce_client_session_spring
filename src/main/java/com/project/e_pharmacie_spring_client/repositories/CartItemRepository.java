package com.project.e_pharmacie_spring_client.repositories;

import com.project.e_pharmacie_spring_client.models.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer>,CartItemRepositoryCustom {
    
}