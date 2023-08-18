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
	id 'net.researchgate.release' version '3.0.0'

}

group = 'com.nmcwilli'
version = '0.1.4-SNAPSHOT'
sourceCompatibility = '17'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.mariadb.jdbc:mariadb-java-client'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.projectlombok:lombok:1.18.26'
	annotationProcessor 'org.projectlombok:lombok:1.18.26'
	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
	testImplementation('org.springframework.boot:spring-boot-starter-test')
}

test {
	useJUnitPlatform()
}

release {
	// Configure release options
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
If you need to do a new docker build, then run: 
```
docker-compose up --build
```


## DB structure: 
2 Tables:
- User Table 
- Client table

## API Endpoints for testing:
- /api/v1/users/all
- /api/v1/users/add 
- /api/v1/clients
- /api/v1/register

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

Register a new user via Postman:

Send a request to this endpoint with sample RAW JSON Data in Body:
```
http://localhost:8080/api/v1/auth/register
```
```
{
    "username": "username", 
    "password": "Password123",
    "name": "MyAwesome Name",
    "email": "email@gmail.com"
}
```
