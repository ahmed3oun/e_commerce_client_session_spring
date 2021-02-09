package com.project.e_pharmacie_spring_client.repositories;


import com.project.e_pharmacie_spring_client.models.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command,Integer>,CommandRepositoryCustom {
    
}