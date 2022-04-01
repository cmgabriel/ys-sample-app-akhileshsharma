package com.example.yssampleapp.api;

import com.example.yssampleapp.domain.UserClientRequest;
import com.example.yssampleapp.domain.UserClientResponse;
import com.example.yssampleapp.domain.UserServiceRequest;
import com.example.yssampleapp.domain.UserServiceResponse;
import com.example.yssampleapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/accreditation", consumes = "application/json")
    public ResponseEntity<?> isUserAccrededited(@Valid @RequestBody UserClientRequest clientRequest){

        //Throw an exception for bad request in case request is null
        Optional.of(clientRequest).ifPresentOrElse((request) -> {
            log.info("User Request to Accredit Received for user");
        },() -> {
            log.error("Empty request submitted to be processed");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        });

        //validate the user request
        if(!isRequestValid(clientRequest)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //Transforms the request to service request
        UserServiceRequest serviceRequest = new UserServiceRequest();
        BeanUtils.copyProperties(clientRequest, serviceRequest);

        //Call the service endpoint to execute the request.
        UserServiceResponse response = userService.accreditNewUser(serviceRequest);

        //Check if the response is null or not. If not then create the response to be sent to upstream client
        UserClientResponse clientResponse = new UserClientResponse();
        Optional.of(response).ifPresentOrElse((userResponse) -> {
            log.info("User response received from the service");
            log.info("Create Client Response from User Response");
            BeanUtils.copyProperties(userResponse, clientResponse);
            log.info("Upstream response created - Client Response");
        },() -> {
            log.error("Internal server error occurred while processing the request");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        });

        return ResponseEntity.ok(clientResponse);
    }

    /*
    The following method checks for the validity of the request.
    The checks that are currently checked as of now for empty.
     */
    private boolean isRequestValid(UserClientRequest clientRequest) {

        if(!(Optional.ofNullable(clientRequest.getUserId()).isPresent() && Optional.ofNullable(clientRequest.getPayload()).isPresent())) return false;
        if(Optional.ofNullable(clientRequest.getPayload().getDocuments()).isEmpty()) return false;
        return true;
    }
}
