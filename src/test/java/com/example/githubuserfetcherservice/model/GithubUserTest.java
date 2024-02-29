package com.example.githubuserfetcherservice.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GithubUserTest {

    @Test
    public void testGithubUserGettersAndSetters() {
        // Create a GithubUser object
        GithubUser user = new GithubUser();

        // Set properties using setters
        user.setLogin("octocat");
        user.setName("The Octocat");
        user.setAvatarUrl("https://avatars3.githubusercontent.com/u/583231?v=4");
        user.setLocation("San Francisco");
        user.setEmail("octocat@example.com");
        user.setHtmlUrl("https://github.com/octocat");
        user.setCreatedAt("2011-01-25 18:44:36");

        // Create a list of GithubRepo objects
        List<GithubRepo> repos = new ArrayList<>();
        repos.add(new GithubRepo("repo1", "https://github.com/octocat/repo1"));
        repos.add(new GithubRepo("repo2", "https://github.com/octocat/repo2"));
        user.setRepos(repos);

        // Validate properties using getters
        assertEquals("octocat", user.getLogin());
        assertEquals("The Octocat", user.getName());
        assertEquals("https://avatars3.githubusercontent.com/u/583231?v=4", user.getAvatarUrl());
        assertEquals("San Francisco", user.getLocation());
        assertEquals("octocat@example.com", user.getEmail());
        assertEquals("https://github.com/octocat", user.getHtmlUrl());
        assertEquals("2011-01-25 18:44:36", user.getCreatedAt());

        // Validate repos
        assertEquals(repos.size(), user.getRepos().size());
        assertEquals(repos.get(0).getName(), user.getRepos().get(0).getName());
        assertEquals(repos.get(0).getUrl(), user.getRepos().get(0).getUrl());
        assertEquals(repos.get(1).getName(), user.getRepos().get(1).getName());
        assertEquals(repos.get(1).getUrl(), user.getRepos().get(1).getUrl());

        // Test toString method
        String expectedToString = "GithubUser{login='octocat', name='The Octocat', avatarUrl='https://avatars3.githubusercontent.com/u/583231?v=4', location='San Francisco', email='octocat@example.com', htmlUrl='https://github.com/octocat', createdAt='2011-01-25 18:44:36', repos=[" +
                "GithubRepo{name='repo1', html_url='https://github.com/octocat/repo1'}, " +
                "GithubRepo{name='repo2', html_url='https://github.com/octocat/repo2'}]}";
        assertEquals(expectedToString, user.toString());
    }
}
