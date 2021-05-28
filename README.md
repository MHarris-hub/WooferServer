***WOOFER***

**Project Description**


Woofer is a full-stack dog-themed Twitter clone. Users can create a new account and login. Users can create new posts (called woofs) and comment on other users woofs. Users can follow other users and like their woofs. The PostgreSQL database stores user data including name, date of birth, phone number and the credentials for username and password. Users will be spending most of their time in our main page component, where they have a feed made up of posts from users that they followed, the posts will also have comments from different users that have accounts in the application. The front end is built using Angular, Bootstrap, and custom CSS. The application front end is hosted using an AWS S3 bucket. We are running a Spring Boot application for our backend making use of the Spring Boot embedded TomCat server to route and handle the requests from our Angular application. The backend is hosted in a Docker container on an AWS EC2 instance. We also made use of a complete CI/CD pipeline using Jenkins and Docker. We set up webhooks using our source control tools Git and GitHub. We made use of Docker and Jenkinsfile to have complete automatization of our CI/CD pipeline. We make use of the AWS RDS service to host our PostgreSQL database.

**Technologies Used**

    Java
    TypeScript
    HTML
    CSS
    Angular
    Bootstrap
    Spring Boot
    PostgreSQL
    Log4J
    Jenkins
    Gradle
    Mockito
    JUnit

**Features**

    Users can register a new account.
    Users can login to their account.
    Users can create new posts(woofs) as well as edit, and delete their posts.
    Users can view other users woofs.
    Users can like posts and follow other users.

**To-do list**

    JWT/OAuth authentication
    Email verification when a user signs up
    Users can Direct Message(DM) other users
