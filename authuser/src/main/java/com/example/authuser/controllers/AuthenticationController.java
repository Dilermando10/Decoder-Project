package com.example.authuser.controllers;

import com.example.authuser.dtos.UserDto;
import com.example.authuser.enums.UserStatus;
import com.example.authuser.enums.UserType;
import com.example.authuser.models.UserModel;
import com.example.authuser.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@RequestBody UserDto userDto) {
        if (userService.existsByUsername(userDto.getUsername())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username is already Taken!");  //Verificação de Username
        }
        if (userService.existsByEmail(userDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Email is already Taken!");   //Verificação de email
        }

        var userModel = new UserModel();               // Criamos uma Instancia de UserModel
        BeanUtils.copyProperties(userDto,userModel);   // Convertendo UserDto em UserModel
        userModel.setUserStatus(UserStatus.ACTIVE);
        userModel.setUserType(UserType.STUDENT);
        userModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        userModel.setLastUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        userService.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);  // Cadastramos um novo Usuário e retornamos
                                                                           // Todos os dados de Usuário Exceto Password Pois está com a a anotação @jsonIgnore
    }


}
