package com.project.e_pharmacie_spring_client.services;

import com.project.e_pharmacie_spring_client.models.User;
import com.project.e_pharmacie_spring_client.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ServiceUser {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> listAll() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.getOne(id);
    }

    public User getUserByName(String name) {
        return repository.getUserByName(name);
    }

    public User getUserBymail(String mail) {
        return repository.getUserBymail(mail);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteUser(int id) {
        try {
            repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public User updateUser(User user) {
        User existingUser = repository.getOne(user.getId());
        existingUser.setName(user.getName());
        existingUser.setMail(user.getMail());
        existingUser.setPassword(user.getPassword());
        existingUser.setNumber(user.getNumber());
        return existingUser;
    }

    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public boolean checklogin(String mail, String password) {
        Optional<User> optionalUser = findById(mail);
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}