package com.example.githubuserfetcherservice.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepo {
    private String name;
    private String url;

    // Default constructor
    public GithubRepo() {
    }

    // Constructor with arguments
    public GithubRepo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonGetter("url")
    public String getFormattedUrl() {
        if (url != null) {
            return url.replace("https://api.github.com/repos", "https://github.com");
        }
        return null;
    }

    @Override
    public String toString() {
        return "GithubRepo{" +
                "name='" + name + '\'' +
                ", html_url='" + url + '\'' +
                '}';
    }
}

