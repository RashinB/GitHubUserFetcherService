package com.example.githubuserfetcherservice.service;

import com.example.githubuserfetcherservice.model.GithubData;
import com.example.githubuserfetcherservice.model.GithubRepo;
import com.example.githubuserfetcherservice.model.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class GithubService {

    private final RestTemplate restTemplate;

    @Autowired
    public GithubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GithubUser getUserData(String username) {
        String userUrl = "https://api.github.com/users/" + username;
        String reposUrl = "https://api.github.com/users/" + username + "/repos";

        // Fetch user data
        GithubData userData = restTemplate.getForObject(userUrl, GithubData.class);

        // Fetch user repositories
        GithubRepo[] repos = restTemplate.getForObject(reposUrl, GithubRepo[].class);

        // Process data and create GithubUser object
        return processGithubData(userData, repos);
    }

    private GithubUser processGithubData(GithubData userData, GithubRepo[] repos) {
        GithubUser user = new GithubUser();
        user.setLogin(userData.getLogin());
        user.setName(userData.getName());
        user.setAvatarUrl(userData.getAvatar_url());
        user.setLocation(userData.getLocation());
        user.setEmail(userData.getEmail());
        user.setHtmlUrl(userData.getHtml_url());

        // Convert ISO 8601 timestamp to the desired format
        LocalDateTime createdAtDateTime = LocalDateTime.parse(userData.getCreated_at(), DateTimeFormatter.ISO_DATE_TIME);
        String formattedCreatedAt = createdAtDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        user.setCreatedAt(formattedCreatedAt);

        user.setRepos(Arrays.asList(repos));
        return user;
    }
}
