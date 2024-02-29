package com.example.githubuserfetcherservice.service;

import com.example.githubuserfetcherservice.model.GithubData;
import com.example.githubuserfetcherservice.model.GithubRepo;
import com.example.githubuserfetcherservice.model.GithubUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GithubServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GithubService githubService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserData() {
        // Mock data
        String username = "octocat";
        GithubData userData = new GithubData();
        userData.setLogin("octocat");
        userData.setName("The Octocat");
        userData.setAvatar_url("https://avatars3.githubusercontent.com/u/583231?v=4");
        userData.setLocation("San Francisco");
        userData.setEmail(null);
        userData.setHtml_url("https://github.com/octocat");
        userData.setCreated_at("2011-01-25T18:44:36Z");

        GithubRepo[] repos = {
                new GithubRepo("boysenberry-repo-1", "https://github.com/repos/octocat/boysenberry-repo-1"),
                new GithubRepo("git-consortium", "https://github.com/repos/octocat/git-consortium")
        };

        // Mock restTemplate behavior
        when(restTemplate.getForObject("https://api.github.com/users/" + username, GithubData.class))
                .thenReturn(userData);
        when(restTemplate.getForObject("https://api.github.com/users/" + username + "/repos", GithubRepo[].class))
                .thenReturn(repos);

        // Execute the method to be tested
        GithubUser actualUser = githubService.getUserData(username);

        // Verify that the restTemplate methods were called
        verify(restTemplate, times(1)).getForObject("https://api.github.com/users/" + username, GithubData.class);
        verify(restTemplate, times(1)).getForObject("https://api.github.com/users/" + username + "/repos", GithubRepo[].class);

        // Validate the returned GithubUser object
        assertEquals("octocat", actualUser.getLogin());
        assertEquals("The Octocat", actualUser.getName());
        assertEquals("https://avatars3.githubusercontent.com/u/583231?v=4", actualUser.getAvatarUrl());
        assertEquals("San Francisco", actualUser.getLocation());
        assertEquals(null, actualUser.getEmail());
        assertEquals("https://github.com/octocat", actualUser.getHtmlUrl());
        assertEquals("2011-01-25 18:44:36", actualUser.getCreatedAt());
        assertEquals(Arrays.asList(repos), actualUser.getRepos());
    }
}
