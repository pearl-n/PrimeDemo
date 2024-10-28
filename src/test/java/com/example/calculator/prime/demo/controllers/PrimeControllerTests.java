package com.example.calculator.prime.demo.controllers;

import com.example.calculator.prime.demo.response.PrimesResponse;
import com.example.calculator.prime.demo.enums.Algorithm;
import com.example.calculator.prime.demo.services.PrimeService;
import com.example.calculator.prime.demo.utility.FormatUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PrimeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private PrimeController primeController;

    @Mock
    private PrimeService primeService;

    private ObjectMapper objectMapper;
    private XmlMapper xmlMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(primeController).build();
        objectMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
    }

    @Test
    void testFindPrimes_UsingDefaultAlgorithm() throws Exception {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_UsingEratosthenesAlgorithm() throws Exception {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue))
                        .param("algorithm", algo.name()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_UsingSundaramAlgorithm() throws Exception {
        int maxValue = 11;
        Algorithm algo = Algorithm.SUNDARAM;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue))
                        .param("algorithm", algo.name()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_UsingAtkinAlgorithm() throws Exception {
        int maxValue = 11;
        Algorithm algo = Algorithm.ATKIN;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue))
                        .param("algorithm", algo.name()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue1() throws Exception {
        int maxValue = 1;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of();
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue2() throws Exception {
        int maxValue = 2;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue10() throws Exception {
        int maxValue = 10;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue11() throws Exception {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_WithMaxValue100() throws Exception {
        int maxValue = 100;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_AsJsonResponse() throws Exception {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_AsXmlResponse() throws Exception {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue))
                        .accept(MediaType.APPLICATION_XML))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andExpect(content().xml(xmlMapper.writeValueAsString(expectedPrimesResponse)));
    }

    @Test
    void testFindPrimes_AsTextResponse() throws Exception {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);
        PrimesResponse expectedPrimesResponse = new PrimesResponse(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesResponse);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue))
                        .accept(MediaType.TEXT_PLAIN))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_PLAIN))
                .andExpect(content().string(FormatUtils.convertObjectToPrettyJsonString(expectedPrimesResponse)));
    }

}
