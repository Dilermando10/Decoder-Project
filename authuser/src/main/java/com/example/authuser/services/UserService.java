package com.example.authuser.services;

import com.example.authuser.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public interface UserService {
    List<UserModel> findAll();
    Optional<UserModel> findById(UUID userId);

    void delete(UserModel userModelOptional);
}
