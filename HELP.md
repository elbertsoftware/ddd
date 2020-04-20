# Getting Started
* Startup: Run LogicApplication as a Java application
* Access H2 console: http://localhost:8080/h2-console
* Connect to in-memory database: jdbc:h2:mem:testdb
* Initialize database: insert into snack_machine_dto (id, cent_count, dime_count, quarter_count, dollar_count, five_dollar_count, twenty_dollar_count, transaction_cent_count, transaction_dime_count, transaction_quarter_count, transaction_dollar_count, transaction_five_dollar_count, transaction_twenty_dollar_count) values (1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0);
* Access UI: http://localhost:8080/SnackMachineView.html

# Unit tests:
* Run SnackMachineTest as a Java application

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/gradle-plugin/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

