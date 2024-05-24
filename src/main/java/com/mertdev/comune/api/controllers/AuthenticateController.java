package com.mertdev.comune.api.controllers;

import com.mertdev.comune.Exceptions.UnavailableEmailException;
import com.mertdev.comune.Exceptions.AccountNotFoundException;
import com.mertdev.comune.bussiness.abstracts.AuthenticationService;
import com.mertdev.comune.bussiness.requests.CreateCommunityRequest;
import com.mertdev.comune.bussiness.requests.CreateUserRequest;
import com.mertdev.comune.bussiness.requests.ExistsUserRequest;
import com.mertdev.comune.bussiness.responses.AuthenticatedAccountResponse;
import com.mertdev.comune.bussiness.responses.CreatedCommunityResponse;
import com.mertdev.comune.bussiness.responses.CreatedUserResponse;
import com.mertdev.comune.bussiness.responses.ExceptionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/v1/no-auth/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticateController {

    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticatedAccountResponse> login(@RequestBody ExistsUserRequest existsUserRequest){
        log.info("Login user: {}",existsUserRequest.getEmail() );
        AuthenticatedAccountResponse response = authenticationService.userLogin(existsUserRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<CreatedUserResponse> register(@ModelAttribute CreateUserRequest createUserRequest){
        log.info("Creating user: {}", createUserRequest.getEmail());
        CreatedUserResponse response = authenticationService.userRegister(createUserRequest);
        return ResponseEntity.created(URI.create("/api/v1/no-auth/login")).body(response);
    }
    @PostMapping("/community-register")
    public ResponseEntity<CreatedCommunityResponse> communityRegister(CreateCommunityRequest createCommunityRequest) throws IOException {

        CreatedCommunityResponse response = authenticationService.communityRegister(createCommunityRequest);
        return ResponseEntity.created(URI.create("/api/v1/no-auth/login")).body(response);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFoundExceptionHandler(Exception exception){
        log.error("An error occurred: {}", exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ExceptionResponse.builder()
                        .message(exception.getMessage())
                        .errorLocation("UserNotFoundException")
                        .httpStatus(HttpStatus.UNAUTHORIZED.toString())
                        .build()
        );
    }
    @ExceptionHandler(UnavailableEmailException.class)
    public ResponseEntity<ExceptionResponse> exception(UnavailableEmailException exception){
        log.error("An error occurred: {}", exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(
               ExceptionResponse.builder()
                       .message(exception.getMessage())
                       .errorLocation("UnavailableEmailException")
                       .httpStatus(HttpStatus.CONFLICT.toString())
                       .build()

        );
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> exception(Exception exception){
        log.error("An error occurred: {}", exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ExceptionResponse.builder()
                        .message(exception.getMessage())
                        .errorLocation(exception.getClass().toString())
                        .httpStatus(HttpStatus.CONFLICT.toString())
                        .build()

        );
    }

}
