# GitHub User Fetcher Service

This service integrates a subset of GitHub's data into the application. It provides an endpoint that accepts a GitHub
username and returns the user's data in JSON format, including their repositories.

## Getting Started

To get started with this service, follow these steps:

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/RashinB/GitHubUserFetcherService.git
    ```

2. Navigate to the project directory:

    ```bash
    cd GitHubUserFetcherService
    ```

3. Build the project using Maven:

    ```bash
    mvn clean package
    ```

4. Run the application:
- To run the application, build the project and run the main class GithubApiApplication in **IntelliJ IDEA**.
- Or Run the **JAR** File 
  - Once the project is built successfully, you can run the generated JAR file using the java -jar command. Replace _github-user-fetcher-service.jar_ with the name of your JAR file:
      ```bash
      java -jar target/github-user-fetcher-service.jar
      ```

## Usage

Once the application is running, you can access the endpoint by making a GET request to: http://localhost:8080/user/{username}

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

## Dependencies

- Spring Boot
- Maven

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please fork the repository and submit a pull
request with your changes.

## Built With

- Java
- Spring Boot
- Maven

## Authors

Rashin Bolkameh

## License

This project is licensed under the MIT License. See the LICENSE file for details.

```
This README includes instructions for both building and running the application with Java, as well as testing it using Postman. Feel free to customize it further to fit your specific needs. If you have any questions or need further assistance, please let me know!
```