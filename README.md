# GitHub User Fetcher Service

## Overview
The GitHub User Fetcher Service is a Spring Boot application designed to fetch and merge data from the GitHub API for a
given user. It provides an endpoint that accepts a GitHub username and returns the user's information, including
repositories, in JSON format.

## Architecture
The service is built using Java and Spring Boot framework. It follows a RESTful architecture pattern, with a controller
to handle incoming requests, a service layer to interact with the GitHub API, and model classes to represent GitHub user
and repository data.

## Components:
- **Controller:** Handles incoming HTTP requests and delegates the processing to the service layer.
- **Service:** Interacts with the GitHub API to fetch user data and repositories. It also processes and merges the data
before returning it to the controller.
- **Model:** Contains classes to represent GitHub user and repository data, with annotations to map JSON properties.

## Decisions
- **Spring Boot:** Chosen for its ease of setup, dependency injection, and support for building RESTful APIs.
- **RestTemplate:** Used to make HTTP requests to the GitHub API for fetching user and repository data.
- **Jackson:** Used for JSON serialization and deserialization of GitHub API responses into Java objects.
- **JUnit and Mockito:** Employed for writing unit tests to ensure the correctness of service and model classes.

## Installation and Usage

## Prerequisites

- Java 8 or later installed on your machine.
- Maven installed to build the project.

## Installation Steps

To get started with this service, follow these steps:

1. Clone the repository to your local machine:

    ```
    git clone https://github.com/RashinB/GitHubUserFetcherService.git
    ```

2. Navigate to the project directory:

    ```
    cd GitHubUserFetcherService
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Running the Service

1. After building the project, navigate to the target directory:
   ```
   cd target
   ```
2. Once the project is built successfully:
    - You can run the generated JAR file using the java -jar command.
       ```bash
          java -jar target/github-user-fetcher-service.jar
       ```
    - **OR** use IntelliJ IDEA To run the application,
        - build the project and run the main class GithubApiApplication in **IntelliJ IDEA**.

## Using the Service

Once the application is running, you can access the endpoint by making a GET request
to: http://localhost:8080/user/{username}

Replace `{username}` with the GitHub username you want to retrieve data for.

## Testing with Postman

You can also test the API using Postman:

- Open Postman and create a new request.
- Set the request type to GET.
- Enter the following URL in the request field while Spring Boot application is running:
  http://localhost:8080/user/octocat
- Replace **_octocat_** with the GitHub username you want to retrieve data for.
- Send the request and view the response.

In Postman, when you make a request to the endpoint you've created with the specified username, you will receive a JSON
response similar to the Example Response provided below.

## Example Response

Here is an example JSON response for the endpoint:

#### This JSON response includes:

- the requested user's username
- display name
- avatar URL
- geo location
- email (if available)
- GitHub URL
- account creation date
- and a list of repositories with their names and URLs.

```json
{
  "user_name": "octocat",
  "display_name": "The Octocat",
  "avatar": "https://avatars3.githubusercontent.com/u/583231?v=4",
  "geo_location": "San Francisco",
  "email": null,
  "url": "https://github.com/octocat",
  "created_at": "2011-01-25 18:44:36",
  "repos": [
    {
      "name": "boysenberry-repo-1",
      "url": "https://github.com/repos/octocat/boysenberry-repo-1"
    },
    {
      "name": "git-consortium",
      "url": "https://github.com/repos/octocat/git-consortium"
    }
  ]
}
 ```

## Conclusion

The GitHub User Fetcher Service provides a simple yet effective way to fetch and merge GitHub user data using the GitHub
API. It's easily deployable and can be integrated into various applications to enhance their functionality with GitHub
data.