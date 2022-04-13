package com.example.authuser.services.impl;

import com.example.authuser.repositories.UserCourseRepository;
import com.example.authuser.services.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    UserCourseRepository userCourseRepository;

}


