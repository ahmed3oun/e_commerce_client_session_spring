package com.project.e_pharmacie_spring_client.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.project.e_pharmacie_spring_client.models.Category;
import com.project.e_pharmacie_spring_client.models.Product;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    EntityManager entity;

    @Override
    public List<Product> listProductByCategory(Category category) {
        Query query = entity.createNativeQuery("SELECT v.* FROM product v WHERE v.category_id=?", Product.class);
        query.setParameter(1, category.getId());
        return (List<Product>) query.getResultList();
    }

}