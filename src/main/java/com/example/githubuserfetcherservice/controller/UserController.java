package com.example.githubuserfetcherservice.controller;

import com.example.githubuserfetcherservice.model.GithubUser;
import com.example.githubuserfetcherservice.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class UserController {

    private final GithubService githubDataService;

    @Autowired
    public UserController(GithubService githubDataService) {
        this.githubDataService = githubDataService;
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<GithubUser> getUser(@PathVariable String username) {

        GithubUser user = githubDataService.getUserData(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Exception handler for HttpClientErrorException
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleHttpClientErrorException(HttpClientErrorException ex) {
        // Handle HTTP 404 error
        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.notFound().build();
        }
        // Handle other HTTP errors
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getStatusText());
    }

    // Exception handler for other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}