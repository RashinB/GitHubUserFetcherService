package com.example.githubuserfetcherservice.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GithubDataTest {

    @Test
    public void testGetFormattedUrl() {
        // Create GithubRepo
        GithubRepo repo = new GithubRepo("repo_name", "https://api.github.com/repos/username/repo_name");

        // Create list of repos
        List<GithubRepo> repos = new ArrayList<>();
        repos.add(repo);

        // Create GithubData
        GithubData githubData = new GithubData();
        githubData.setRepos(repos);

        // Test getFormattedUrl()
        assertEquals("https://github.com/username/repo_name", githubData.getRepos().get(0).getFormattedUrl());
    }
}
