package com.example.githubuserfetcherservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubData {
    private String login;
    private String name;
    private String avatar_url;
    private String location;
    private String email;
    private String html_url;
    private String created_at;
    private List<GithubRepo> repos;

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

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
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

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<GithubRepo> getRepos() {
        return repos;
    }

    public void setRepos(List<GithubRepo> repos) {
        this.repos = repos;
    }

    @Override
    public String toString() {
        return "GithubData{" +
                "loginData='" + login + '\'' +
                ", name='" + name + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", html_url='" + html_url + '\'' +
                ", created_at='" + created_at + '\'' +
                ", repos=" + repos +
                '}';
    }
}
