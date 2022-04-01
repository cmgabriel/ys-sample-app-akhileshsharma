package com.example.yssampleapp.service;

import com.example.yssampleapp.domain.UserServiceRequest;
import com.example.yssampleapp.domain.UserServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public UserServiceResponse accreditNewUser(UserServiceRequest userServiceRequest) {

        log.info("User Service Response - started");

        boolean isAccredited = !(Math.random() < 0.5);

        //Build the response on the basis of the random number generated above.
        log.info("User Service Response - completed");
        return UserServiceResponse.builder()
                .success(true)
                .isAccredited(isAccredited)
                .build();
    }
}
