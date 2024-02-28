package com.example.githubuserfetcherservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUser {
    @JsonProperty("user_name")
    private String login;
    @JsonProperty("display_name")
    private String name;
    @JsonProperty("avatar")
    private String avatarUrl;
    @JsonProperty("geo_location")
    private String location;
    @JsonProperty("email")
    private String email;
    @JsonProperty("url")
    private String htmlUrl;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("repos")
    private List<GithubRepo> repos;
    private String username;
    // Constructors
    public GithubUser() {
    }

    // Getters and setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<GithubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GithubRepo> repos) {
        this.repos = repos;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", repos=" + repos +
                '}';
    }
}

