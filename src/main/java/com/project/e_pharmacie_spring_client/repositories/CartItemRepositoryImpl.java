package com.project.e_pharmacie_spring_client.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.project.e_pharmacie_spring_client.models.CartItem;
import com.project.e_pharmacie_spring_client.models.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class CartItemRepositoryImpl implements CartItemRepositoryCustom {
    @PersistenceContext
    EntityManager entity;

    @Override
    public List<CartItem> listCartItemsByUser(User user) {
        Query query = entity.createNativeQuery("SELECT c.* FROM cart_items c WHERE c.user_id= ?", CartItem.class);
        query.setParameter(1, user.getId());
        return (List<CartItem>) query.getResultList();
    }

    @Override
    public void deleteAllCartItemsByUser(User user) {
        Query query = entity.createNativeQuery("DELETE FROM cart_items c WHERE c.user_id= ?", CartItem.class);
        query.setParameter(1, user.getId());

    }

}