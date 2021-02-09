package com.project.e_pharmacie_spring_client.repositories;

import com.project.e_pharmacie_spring_client.models.User;

public interface UserRepositoryCustom {
    User getUserByName(String name);
    User getUserBymail(String mail);

}
