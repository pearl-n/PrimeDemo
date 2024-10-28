package com.example.calculator.prime.demo.controllers;

import com.example.calculator.prime.demo.dto.PrimesDTO;
import com.example.calculator.prime.demo.enums.Algorithm;
import com.example.calculator.prime.demo.services.PrimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
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

    @InjectMocks
    private PrimeController primeController;

    @Mock
    private PrimeService primeService;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(primeController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testFindPrimes_WithValidMaxValue() throws Exception {
        int maxValue = 100;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );
        PrimesDTO expectedPrimesDTO = new PrimesDTO(algo.getName(), expectedPrimes);

        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(expectedPrimesDTO);

        mockMvc.perform(get("/primes")
                        .param("maxValue", String.valueOf(maxValue))
                        .param("algorithm", algo.name())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedPrimesDTO)));
    }

    @Test
    void testFindPrimes_WithDefaultAlgorithm() throws Exception {
        int maxValue = 100;
        Algorithm algo = Algorithm.ATKIN;
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );

        PrimesDTO primesDTO = new PrimesDTO(algo.name(), expectedPrimes);
        when(primeService.calculatePrimeNumbersUpTo(maxValue, algo)).thenReturn(primesDTO);

        mockMvc.perform(get("/prime-numbers")
                        .param("maxValue", String.valueOf(maxValue))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value(algo.name()))
                .andExpect(jsonPath("$.primes").isArray())
                .andExpect(jsonPath("$.primes.length()").value(expectedPrimes.size()));
    }

    @Test
    void testFindPrimes_WithInvalidMaxValue() throws Exception {
        mockMvc.perform(get("/prime-numbers")
                        .param("maxValue", "-5") // Invalid value
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
