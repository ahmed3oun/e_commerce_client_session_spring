package com.project.e_pharmacie_spring_client.repositories;

import com.project.e_pharmacie_spring_client.models.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Repository
@Transactional(readOnly = true)
public class AdminRepositoryImpl implements AdminRepositoryCustom {
    @PersistenceContext
    EntityManager entity;

    @Override
    public Admin getUserByName(String username) {
        Query query=entity.createNativeQuery("SELECT u.* FROM admin u"+" WHERE u.username LIKE ?",Admin.class);
        query.setParameter(1, username+"%");
        return (Admin) query.getSingleResult();
    }

}
