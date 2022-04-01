package com.example.yssampleapp.service;

import com.example.yssampleapp.domain.UserServiceRequest;
import com.example.yssampleapp.domain.UserServiceResponse;


public interface UserService {
    public UserServiceResponse accreditNewUser(UserServiceRequest userServiceRequest);
}
