package com.project.e_pharmacie_spring_client.repositories;

import com.project.e_pharmacie_spring_client.models.Admin;

public interface AdminRepositoryCustom {
    Admin getUserByName(String name);
}
