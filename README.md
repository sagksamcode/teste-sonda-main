# Transaction Gateway

## Description
Application to store (persist using H2 Memory DB) Planets and Probes API.
The primary functionality of this API involves the interaction with planetary systems. Users can define a planet's specifications, including its dimensions, and deploy probes to explore these celestial bodies. The probes can be guided using a set of commands, allowing for precise control over their landing and exploration activities.

## Tools and Technologies Used

- **Spring Boot:** The core framework.

- **IDE:** IntelliJ.

- **Maven:** Build automation tools to manage dependencies and build projects.

- **Git and Version Control Systems:** Git and GitHub for version control.

- **Database Tools:** H2 Database for database management.

- **API Documentation Tools:** README.MD for API documentation.

- **Test Application:** Postman

## Prerequisites

Before you can use the Spring Boot API with Maven, make sure you have the following prerequisites in place:

1. **Java Development Kit (JDK):** Ensure that you have the Java Development Kit (JDK) installed on your system. You can check if Java is installed by running `java -version` in your terminal. If it's not installed, download and install it from the [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Maven Build Tool:** Maven is the build tool for your project. Make sure you have Maven installed. You can check your Maven installation by running `mvn -version`. If it's not installed, follow the installation instructions for Maven at [Maven Installation Guide](https://maven.apache.org/install.html).

3. **Spring Boot Application:** You should have your Spring Boot application source code and configuration files ready. Ensure that your application is set up and ready to run with Maven.

4. **Terminal or IDE:** You will need access to a terminal to execute Maven commands for building and running your Spring Boot application or IDE like [IntelliJ](https://www.jetbrains.com/pt-br/idea/download/).

Make sure to meet these prerequisites before running and using your Spring Boot API with Maven.



## Installation
```bash 
git clone https://github.com/sagksamcode/currency-converter.git
```
```bash 
mvn clean package 
```
```bash 
$ docker build -t docker build -t sonda.candidato:latest .
```
```bash 
$ docker run -t  docker run -p 8080:8080 {hash-of-the-image}
```

## **Features**
- ### Endpoint to create a new planet.

**URL:** `http://localhost:8080/planets`
**Method:** `POST`
### Request Body

The request body should be in JSON format and include the following fields:

```json
{
    "id": 1,
    "name": "Plutao",
    "width": 5,
    "height": 5
}
```

- ### Endpoint to create a new probe.

**URL:** `http://localhost:8080/probes`
**Method:** `POST`
### Request Body

The request body should be in JSON format and include the following fields:

```json
{
    "id": 3,
    "planetId": 1,
    "name": "Probe Two",
    "positionX": 3,
    "positionY": 3,
    "direction": "WEST"
}
```

- ### Endpoint to put a new command.

**URL:** `http://localhost:8080/probes/commands`
**Method:** `POST`
### Request Body

The request body should be in JSON format and include the following fields:

```json
{
    "probeId": 2,
    "commands":[
        "M", "M", "R", "M", "M", "R", "M", "R", "R", "M", "L"
    ]
}
```

- ### Endpoint to retrieve a specific planet by its ID.

**URL:** `http://localhost:8080/planets/1`
**Method:** `GET`
### Response

```json
HTTP/1.1 200 OK
Content-Type: application/json

{
    "id": 1,
    "name": "Plutao",
    "width": 5,
    "height": 5
}
```

- ### Endpoint to retrieve all planets

**URL:** `http://localhost:8080/planets/`
**Method:** `GET`
### Response

```json
HTTP/1.1 200 OK
Content-Type: application/json

[
    {
        "id": 1,
        "name": "Plutao",
        "width": 5,
        "height": 5
    }
]
```


- ### Endpoint to retrieve update a specific planet by its id

**URL:** `http://localhost:8080/planets/1`
**Method:** `PUT`
### Response

```json
HTTP/1.1 200 OK
Content-Type: application/json

{
    "name": "Netuno",
    "width": 400,
    "height": 400
}
```
- ### Endpoint to retrieve a specific probe by its ID.

**URL:** `http://localhost:8080/probes/1`
**Method:** `GET`
### Response

```json
HTTP/1.1 200 OK
Content-Type: application/json

{
    "id": 3,
    "coordinate": {
        "id": 0,
        "verticalAxis": 3,
        "horizontalAxis": 3
    },
    "planet": {
        "id": 1,
        "name": "Plutao",
        "width": 5,
        "height": 5
    },
    "direction": null
}
```

- ### Endpoint to retrieve all planets

**URL:** `http://localhost:8080/probes/`
**Method:** `GET`
### Response

```json
HTTP/1.1 200 OK
Content-Type: application/json

[
    {
        "id": 3,
        "coordinate": {
            "id": 0,
            "verticalAxis": 3,
            "horizontalAxis": 3
        },
        "planet": {
            "id": 1,
            "name": "Plutao",
            "width": 5,
            "height": 5
        },
        "direction": null
    }
]
```
### Contributing
Send a pull requests 😆💻
