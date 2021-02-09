package com.project.e_pharmacie_spring_client.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.project.e_pharmacie_spring_client.models.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class CommandRepositoryImpl implements CommandRepositoryCustom {
    @PersistenceContext
    EntityManager entity;
    private List<Command> list;

    @Override
    public List<Command> listCommandByProduct(Product product) {
        Query query=entity.createNativeQuery("SELECT c.* FROM command c WHERE c.product_id= ?");
        query.setParameter(1, product.getId());
        list = (List<Command>) query.getResultList();
        return list;
    }

    @Override
    public List<Command> listCommandByUser(User user) {
        Query query=entity.createNativeQuery("SELECT c.* FROM command c WHERE c.user_id= ?");
        query.setParameter(1, user.getId());
        list = ( List<Command>) query.getResultList();
        return null;
    }
    
}