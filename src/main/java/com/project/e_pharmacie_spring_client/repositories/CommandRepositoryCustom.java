package com.project.e_pharmacie_spring_client.repositories;

import java.util.List;

import com.project.e_pharmacie_spring_client.models.Command;
import com.project.e_pharmacie_spring_client.models.Product;
import com.project.e_pharmacie_spring_client.models.User;

public interface CommandRepositoryCustom {
    List<Command> listCommandByProduct(Product product);
    List<Command> listCommandByUser(User user);

    
}