package com.project.e_pharmacie_spring_client.services;

import java.util.List;

import com.project.e_pharmacie_spring_client.models.Command;
import com.project.e_pharmacie_spring_client.models.Product;
import com.project.e_pharmacie_spring_client.models.User;
import com.project.e_pharmacie_spring_client.repositories.CommandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    @Autowired
    private CommandRepository repository;

    public Command saveCommand(Command command) {
        return repository.save(command);
    }

    public List<Command> listAllCommands() {
        return repository.findAll();
    }

    public List<Command> getCommandByProduct(Product product) {
        return repository.listCommandByProduct(product);
    }
    
    
    public List<Command> getCommandByUser(User user) {
        return repository.listCommandByUser(user);
    }

    public Command getCommandByID(int id) {
        return repository.getOne(id);
    }

    public void deleteCommand(int id) {
        try {
            repository.deleteById(id);   
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}