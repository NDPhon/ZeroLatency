package com.zerolatency.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerolatency.backend.model.Users;
import com.zerolatency.backend.repo.usersRepo;
import java.util.List;

@Service
public class usersService {
    @Autowired
    private usersRepo userRepo;

    public Users findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users login(String username, String password) {
        Users user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
