package com.talkevents.cassandra.services;

import com.talkevents.cassandra.models.User;
import com.talkevents.cassandra.repositories.UserRepositoy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepositoy userRepositoy;

    public UserService(UserRepositoy userRepositoy){
        this.userRepositoy = userRepositoy;
    }

    public List<User> getAll(){
        return userRepositoy.findAll();
    }

    public User getById(UUID id){return userRepositoy.findById(id).orElse(null);}

    public User save(User user){
        user.setId(UUID.randomUUID());
        return userRepositoy.save(user);
    }

    public void update(User user){
        var userToUpdate = userRepositoy.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + user.getId()));
        userToUpdate.setName(user.getName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setEmail(user.getEmail());
        userRepositoy.save(user);
    }

    public void delete(UUID id){
        userRepositoy.deleteById(id);
    }
}
