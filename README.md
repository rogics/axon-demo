# Axon Proof of Concept - Axon for event distribution

## Build

Running three maven goals: clean, install and dockerBuild to install libraries in local maven repository and to create docker images of `publisher` and `subscriber` applications (in local docker registry/daemon)

REQUIREMENTS: Java 11+, Docker.

```shell
./mvnw clean install jib:dockerBuild
```

## Run in Docker - locally

```shell
docker-compose up -d
```

Infrastructure services available:
- [Axon Server Admin UI - http://localhost:8024/](http://localhost:8024/)
- Posgresql - localhost:5432

Applications available:
- [Publisher Health Endpoint - http://localhost:8089/actuator/health](http://localhost:8089/actuator/health)
- [Publisher Swagger UI Endpoint - http://localhost:8089/swagger-ui.html](http://localhost:8089/swagger-ui.html)


- [Subscriber Health Endpoint - http://localhost:8099/actuator/health](http://localhost:8099/actuator/health)
- [Subscriber Swagger UI Endpoint - http://localhost:8099/swagger-ui.html](http://localhost:8099/actuator/health)

Databases available:
- Publisher PostgreSQL DB: JDBC URL: `jdbc:postgresql://localhost:5432/publisherdb` ; user name: `root` ; password: `root`
- Subscriber PostgreSQL DB: JDBC URL: `jdbc:postgresql://localhost:5432/subscriberdb` ; user name: `root` ; password: `root`


## Stop Docker compose locally
```shell
docker-compose down -v
```
