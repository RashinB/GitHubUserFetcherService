package com.example.githubuserfetcherservice.exception;

public class GithubServiceException extends RuntimeException {

    public GithubServiceException(String message) {
        super(message);
    }

    public GithubServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
