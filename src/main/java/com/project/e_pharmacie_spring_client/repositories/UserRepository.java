package com.project.e_pharmacie_spring_client.repositories;

import java.util.Optional;

import com.project.e_pharmacie_spring_client.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>,UserRepositoryCustom {
    Optional<User> findById(String id);
}