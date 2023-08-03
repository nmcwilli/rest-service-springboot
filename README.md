## RESTful API w/ Spring Boot

### Description

This is a RESTful API built with Spring Boot that can be used as a starting place.

Stack:
- MariaDB (database)
- Back-end (Spring Boot w/ Tomcat)

Gradle build.gradle:
```aidl
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

Deploy command:
```aidl
`./gradlew bootRun`
```

DB structure: 
1 User Table for demo purposes

API Endpoints for testing:
- /users/all
- /users/add 
- /greeting

Sample Curl Add User:
```
$ curl http://localhost:8080/users/add -d name=First -d email=someemail@someemailprovider.com
```

Sample CURL Grab all User Data:
```aidl
$ curl http://localhost:8080/users/all
```


