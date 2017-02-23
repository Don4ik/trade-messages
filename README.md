Trade Messages Application.

**Overview**

This application consumes trade messages via rest endpoint and then user can view all messages in web browser.
Technologies used (backend): Java, Spring Boot, JPA (with Hibernate), H2 etc.
Technologies used (frontend): Angular JS 2, Node.js, TypeScript. etc.

**Usage**

1. Run `mvn clean install` from root directory
2. Run spring boot application: `mvn spring-boot:run

Now application is up and running and you can add new trade messages via REST endpoint (`http://localhost:8080/messages` I assume local deployment starting from here)
You can navigate your browser to `http://localhost:8080` to view all trade messages in basic Angular app.
You can also issue GET request to `http://localhost:8080/messages` to receive all messages in JSON format.