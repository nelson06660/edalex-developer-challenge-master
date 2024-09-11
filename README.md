# Edalex Developer Challenge

## SERVER config

# Added some dependencies configuration in the build.gradle 
 # Added to support H2 Databse 
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
 # Added JUnit 5
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'

 # Added Mockito
    testImplementation 'org.mockito:mockito-core:4.0.0'
    testImplementation 'org.mockito:mockito-junit-jupiter:4.0.0'


## Spring Data JPA for ORM, i created application.properties file for H2 Database configuration, database file is stored in the ./data/messages file
# spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.url=jdbc:h2:file:./data/messages
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true

## Client  config

# added .env file to bypass some issues in @babel  versions
SKIP_PREFLIGHT_CHECK=true

# added dependencies to support Material-UI

 "@mui/icons-material": "^6.0.2",
 "@mui/material": "^6.0.2",

 # added dependencies  to support testing
    "@testing-library/jest-dom": "^5.17.0",
    "@testing-library/react": "^11.2.7",
    "@testing-library/user-event": "^12.8.3",
    "@types/jest": "^26.0.24",


