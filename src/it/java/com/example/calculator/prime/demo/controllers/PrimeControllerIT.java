package com.example.calculator.prime.demo.controllers;

import com.example.calculator.prime.demo.enums.Algorithm;
import com.example.calculator.prime.demo.response.PrimesResponse;
import com.example.calculator.prime.demo.utility.FormatUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PrimeControllerIT {

    @LocalServerPort
    private int port;

    private static ObjectMapper objectMapper;
    private static XmlMapper xmlMapper;

    @BeforeAll
    public static void beforeAll() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        objectMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
    }

    @BeforeEach
    public void beforeEach() {
        RestAssured.baseURI = "http://localhost:" + port + "/api/v1/prime-demo/";
    }

    @Test
    void testFindPrimes_UsingDefaultAlgorithm() throws JsonProcessingException {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_UsingEratosthenesAlgorithm() throws JsonProcessingException {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .param("algorithm", algo.name())
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_UsingSundaramAlgorithm() throws JsonProcessingException {
        int maxValue = 11;
        Algorithm algo = Algorithm.SUNDARAM;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .param("algorithm", algo.name())
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_UsingAtkinAlgorithm() throws JsonProcessingException {
        int maxValue = 11;
        Algorithm algo = Algorithm.ATKIN;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .param("algorithm", algo.name())
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue1() throws JsonProcessingException {
        int maxValue = 1;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of();
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue2() throws JsonProcessingException {
        int maxValue = 2;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue10() throws JsonProcessingException {
        int maxValue = 10;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue11() throws JsonProcessingException {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue100() throws JsonProcessingException {
        int maxValue = 100;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_AsJsonResponse() throws JsonProcessingException {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(equalTo(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_AsXmlResponse() throws JsonProcessingException {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .accept(MediaType.APPLICATION_XML_VALUE)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .body(equalTo(xmlMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_AsTextResponse() throws JsonProcessingException {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        given()
                .param("maxValue", maxValue)
                .accept(MediaType.TEXT_PLAIN_VALUE)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(MediaType.TEXT_PLAIN_VALUE)
                .body(equalTo(FormatUtils.convertObjectToPrettyJsonString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMissingMaxValue() {
        given()
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body("message", equalTo("Required request parameter 'maxValue' for method parameter type int is not present"));
    }

    @Test
    void testFindPrimes_WithInvalidMaxValue() {
        int maxValue = -1;
        given()
                .param("maxValue", maxValue)
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body("message", equalTo("findPrimes.maxValue: must be greater than or equal to 0"));
    }

    @Test
    void testFindPrimes_WithInvalidAlgorithm() {
        int maxValue = 11;
        given()
                .param("maxValue", maxValue)
                .param("algorithm", "something")
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body("message", containsString("Failed to convert value of type 'java.lang.String' to required type 'com.example.calculator.prime.demo.enums.Algorithm"));
    }

    @Test
    void testFindPrimes_WithInvalidAcceptType() {
        int maxValue = 11;
        given()
                .param("maxValue", maxValue)
                .accept("something")
                .when()
                .get("/primes")
                .then()
                .statusCode(HttpStatus.NOT_ACCEPTABLE.value())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body("message", equalTo("No acceptable representation"));
    }

}
