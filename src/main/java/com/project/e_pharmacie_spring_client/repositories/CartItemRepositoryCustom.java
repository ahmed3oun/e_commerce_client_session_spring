package com.project.e_pharmacie_spring_client.repositories;

import java.util.List;

import com.project.e_pharmacie_spring_client.models.CartItem;
import com.project.e_pharmacie_spring_client.models.User;

public interface CartItemRepositoryCustom {

    List<CartItem> listCartItemsByUser(User user);
    void deleteAllCartItemsByUser(User user);

}
