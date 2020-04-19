# Java API for Docker Blog Post

This will serve as an image source for my Docker related block post

## About

This application pings [randomuser](https://randomuser.me/) api and stores the data in an in memory database.

## How to Use

* Clone project to a directory on your pc

    ``git clone https://github.com/Gogetter/java-blog-posts.git``

* Change directory into `java-for-docker-blog-post` project

    ```cd java-blog-posts/java-for-docker-blog-post```

* Launch a Command Line Interface (or Terminal) and run below command to create a jar for the project

    ```./gradlew clean build```

* Run below command to start the application on port `8095`

    ```java -jar build/libs/java-for-docker-blog-post-0.1.0.jar```

* Copy and paste below url into a browser (or Postman) to view returned data

    ```http://localhost:8095/api/users```

## Create a Docker Image

* Run below command to create a Docker image for the application

    ```docker build -t dockerblogposts/java-example:apr-2020 .```
    
## Create a container from image

* Run below command to create a Docker container from the just created image

    ```docker run -d -p 8099:8095 --name myapp dockerblogposts/java-example:apr-2020```

* Copy and paste below url into a browser (or Postman) to view returned data

    ```http://localhost:8099/api/users```

