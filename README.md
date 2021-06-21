# Event-driven and serverless with Spring Cloud and Spring Native (jLove Conference 2021)

Examples from the talk I have at jLove Conference 2021.

## Serverless application with Spring Cloud Function and Spring Native

Prerequisites: Java 11

Build the `web-function` application as a native container image:

```bash
./gradlew bootBuildImage
```

Send a POST request:

```bash
echo 'piano' | http POST :8080
```

## Event-driven application with Spring Cloud Function and Spring Cloud Stream

Prerequisites: Java 16

Run a RabbitMQ container:

```bash
docker-compose up -d
```

Build the `stream-function` application as a container image:

```bash
./gradlew bootBuildImage
```
