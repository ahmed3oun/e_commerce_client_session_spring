package com.project.e_pharmacie_spring_client.services;

import java.util.List;

import com.project.e_pharmacie_spring_client.models.CartItem;
import com.project.e_pharmacie_spring_client.models.User;
import com.project.e_pharmacie_spring_client.repositories.CartItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    @Autowired 
    private CartItemRepository repository;

    public CartItem saveCartItem(CartItem cartItem) {
     return repository.save(cartItem);
    }

    public List<CartItem> listAllCartItems() {
        return repository.findAll();
    }

    public List<CartItem> listCartItemsByUser(User user) {
        return repository.listCartItemsByUser(user);
    }

    public void deleteCartItem(int id ) {
        repository.deleteById(id);
    }

    public void deleteAllCartItemsByUser(User user) {
        repository.deleteAllCartItemsByUser(user);
    }

    




    
}