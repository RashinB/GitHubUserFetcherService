package com.example.githubuserfetcherservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GithubRepoTest {

    @Test
    public void testGettersAndSettersAndGetFormattedUrl() {
        // Create GithubRepo
        GithubRepo repo = new GithubRepo();
        repo.setUrl("https://api.github.com/repos/username/repo_name");

        // Test getFormattedUrl()
        assertEquals("https://github.com/username/repo_name", repo.getFormattedUrl());
    }

    @Test
    public void testGetFormattedUrl() {
        // Given
        String apiUrl = "https://api.github.com/repos/octocat/boysenberry-repo-1";
        String expectedUrl = "https://github.com/octocat/boysenberry-repo-1";

        // When
        GithubRepo repo = new GithubRepo();
        repo.setUrl(apiUrl);

        // Then
        assertEquals(expectedUrl, repo.getFormattedUrl());
    }
}

