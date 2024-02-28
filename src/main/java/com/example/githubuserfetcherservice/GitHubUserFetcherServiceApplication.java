package com.example.githubuserfetcherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
	public class GitHubUserFetcherServiceApplication {

		public static void main(String[] args) {
			SpringApplication.run(GitHubUserFetcherServiceApplication.class, args);
		}
	}
