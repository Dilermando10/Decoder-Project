package com.example.authuser.services.impl;

import com.example.authuser.models.UserModel;
import com.example.authuser.repositories.UserRepository;
import com.example.authuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(UUID userId) {
        return userRepository.findById(userId);
    }



    @Override
    public void delete (UserModel userModel) {
        userRepository.delete(userModel);
    }

}
