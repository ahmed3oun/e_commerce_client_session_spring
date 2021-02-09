package com.project.e_pharmacie_spring_client.repositories;

import com.project.e_pharmacie_spring_client.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer>, AdminRepositoryCustom {
}
