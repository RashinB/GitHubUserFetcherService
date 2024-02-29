package com.example.githubuserfetcherservice.service;

import com.example.githubuserfetcherservice.exception.GithubServiceException;
import com.example.githubuserfetcherservice.exception.UserNotFoundException;
import com.example.githubuserfetcherservice.model.GithubData;
import com.example.githubuserfetcherservice.model.GithubRepo;
import com.example.githubuserfetcherservice.model.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
        try {
            String userUrl = "https://api.github.com/users/" + username;
            String reposUrl = "https://api.github.com/users/" + username + "/repos";

            // Fetch user data
            GithubData userData = restTemplate.getForObject(userUrl, GithubData.class);

            // Fetch user repositories
            GithubRepo[] repos = restTemplate.getForObject(reposUrl, GithubRepo[].class);

            // Process data and create GithubUser object
            return processGithubData(userData, repos);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                try {
                    throw new UserNotFoundException("User not found");
                } catch (UserNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                throw e;
            }
        } catch (Exception e) {
            throw new GithubServiceException("An error occurred while fetching user data", e);
        }
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
