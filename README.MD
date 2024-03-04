# Twitter Clone API

This project implements a simple Twitter-like API using Groovy, Spring Boot, MongoDB, Gradle, and Spock.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features

- User authentication (registration, login, logout)
- Posting tweets
- Following/unfollowing users
- Liking/unliking tweets
- Commenting on tweets
- Viewing user feed and specific user's feed

## Technologies Used

- Groovy
- Spring Boot
- MongoDB
- Gradle
- Spock

## Getting Started

To get started with the project, follow these steps:

1. Clone this repository: `git clone https://github.com/yourusername/twitter-clone.git`
2. Navigate to the project directory: `cd twitter-clone`
3. Build the project: `./gradlew build`
4. Run the application: `./gradlew bootRun`
5. The application will be accessible at: `http://localhost:8080`

## API Endpoints

The following are the main API endpoints:

- `POST /api/auth/register`: Register a new user.
- `POST /api/auth/login`: Login and authenticate user.
- `POST /api/auth/logout`: Logout user.
- `POST /api/posts`: Create a new post.
- `GET /api/posts`: Get all posts.
- `GET /api/posts/{postId}`: Get a specific post.
- `POST /api/posts/{postId}/like`: Like a post.
- `DELETE /api/posts/{postId}/like`: Unlike a post.
- `POST /api/posts/{postId}/comment`: Comment on a post.
- `GET /api/users/{userId}/feed`: Get user's feed.
- `GET /api/users/{userId}/posts`: Get posts of a specific user.
- `POST /api/users/{userId}/follow`: Follow a user.
- `DELETE /api/users/{userId}/unfollow`: Unfollow a user.

## Testing

Unit and integration tests are written using Spock framework. To run the tests, execute:

