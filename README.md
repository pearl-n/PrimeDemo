# PrimeDemo Microservice

## Overview
This microservice is built in Spring Boot using Maven. It provides a REST API which calculates and returns all prime numbers up to and including a given number.

## Requirements

- JDK 17 or later
- Maven 3.3.x or later

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/pearl-n/PrimeDemo.git
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

The application will start on http://localhost:8080 by default.

You will be able to access the Swagger UI at:

    ~/api/v1/prime-demo/swagger-ui/index.html

## Usage

### Endpoint

To calculate all prime numbers up to and including a given number, use the following endpoint:

    GET /api/v1/prime-demo/primes

### Request Parameters

| Parameter | Type        | Description                                                            | Example      | Required | Default Value   |
|-----------|-------------|------------------------------------------------------------------------|--------------|----------|------------------|
| `maxValue` | Query param | The maximum value of the prime numbers to be returned                 | 11           | ✔️      | N/A              |
| `algorithm` | Query param | The algorithm to be used                                              | ATKIN | ❌       | ERATOSTHENES     |

### Example Request

To get all prime numbers up to 11:
```bash
curl -X 'GET' \
  'http://localhost:8080/api/v1/prime-demo/primes?maxValue=11&algorithm=ATKIN' \
  -H 'accept: application/json'
```

### Example Response

```json
{
  "algorithm": "Sieve of Atkin",
  "primes": [
    2,
    3,
    5,
    7,
    11
  ]
}
```

## Testing

To run the tests, use the following command:
```bash
mvn test
```
