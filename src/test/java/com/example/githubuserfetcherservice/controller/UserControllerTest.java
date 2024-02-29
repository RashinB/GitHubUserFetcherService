package com.example.githubuserfetcherservice.controller;

import com.example.githubuserfetcherservice.model.GithubUser;
import com.example.githubuserfetcherservice.service.GithubService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Mock
    private GithubService githubService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this);
        userController = new UserController(githubService);
    }

    @Test
    public void testGetUser() {
        // Mock data
        GithubUser user = new GithubUser();
        user.setLogin("testuser");

        // Mock service method
        when(githubService.getUserData("testuser")).thenReturn(user);

        // Call controller method
        ResponseEntity<GithubUser> response = userController.getUser("testuser");

        // Check response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testGetUserFound() {
        String username = "octocat";
        GithubUser mockUser = new GithubUser();
        mockUser.setLogin(username);
        mockUser.setName("The Octocat");
        mockUser.setAvatarUrl("https://avatars3.githubusercontent.com/u/583231?v=4");
        mockUser.setLocation("San Francisco");
        mockUser.setEmail(null);
        mockUser.setHtmlUrl("https://github.com/octocat");
        mockUser.setCreatedAt("2011-01-25 18:44:36");

        // Mock the service response
        when(githubService.getUserData(username)).thenReturn(mockUser);

        // Call the controller method
        ResponseEntity<GithubUser> response = userController.getUser(username);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
    }

    @Test
    public void testGetUser_NotFound() {
        // Mock service method to return null
        when(githubService.getUserData("nonexistentuser")).thenReturn(null);

        // Call controller method
        ResponseEntity<GithubUser> response = userController.getUser("nonexistentuser");

        // Check response
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void testHandleHttpClientErrorException() {
        // Mock HttpClientErrorException
        HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.NOT_FOUND);

        // Call exception handler method
        ResponseEntity<Object> response = userController.handleHttpClientErrorException(exception);

        // Check response
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testHandleException() {
        // Mock Exception
        Exception exception = new Exception("Test Exception");

        // Call exception handler method
        ResponseEntity<Object> response = userController.handleException(exception);

        // Check response
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An unexpected error occurred", response.getBody());
    }
}