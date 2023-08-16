# REST API w/ Spring Boot

## Description

This is a REST API built with Spring Boot that can be used as a starting point for a Spring Boot back-end.

## Stack:
- MariaDB (Database)
- Backend (Spring Boot w/ Tomcat)

## Gradle build.gradle:
```
plugins {
	id 'org.springframework.boot' version '3.1.0'
	id 'io.spring.dependency-management' version '1.1.0'
	id 'java'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.mariadb.jdbc:mariadb-java-client'
	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
	testImplementation('org.springframework.boot:spring-boot-starter-test')
}

test {
	useJUnitPlatform()
}
```

## To generate a new build, run:
```
./gradlew build
```

## Run command:
```
./gradlew bootRun
```

## Steps to deploy Docker container images using docker-compose
Shut down any existing containers
```
docker-compose down
```
Then run:
```
docker-compose up -d
```


## DB structure: 
2 Tables:
- User Table 
- Client table

## API Endpoints for testing:
- /api/v1/users/all
- /api/v1/users/add 
- /api/v1/clients

## Sample Curl:

View all Clients: 
```
$ curl http://localhost:8080/api/v1/clients
```

Add User:
```
$ curl http://localhost:8080/api/v1/users/add -d name=First -d email=someemail@someemailprovider.com
```

If you are adding via Postman (Post):
```
http://localhost:8080/api/v1/users/add?name=First&email=someemail@someemailprovider.com
```

Sample CURL Grab all User Data:
```
$ curl http://localhost:8080/api/v1/users/all
```


