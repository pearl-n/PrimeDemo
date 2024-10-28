package com.example.calculator.prime.demo.services;

import com.example.calculator.prime.demo.dto.PrimesDTO;
import com.example.calculator.prime.demo.enums.Algorithm;
import com.example.calculator.prime.demo.services.impl.PrimeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PrimeServiceTests {

    @InjectMocks
    private PrimeServiceImpl primeService;

    @Test
    public void testCalculatePrimeNumbersUpTo1WithEratosthenes() {
        int maxValue = 1;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of();

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo2WithEratosthenes() {
        int maxValue = 2;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo10WithEratosthenes() {
        int maxValue = 10;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo11WithEratosthenes() {
        int maxValue = 11;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo100WithEratosthenes() {
        int maxValue = 100;
        Algorithm algo = Algorithm.ERATOSTHENES;
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo1WithSundaram() {
        int maxValue = 1;
        Algorithm algo = Algorithm.SUNDARAM;
        List<Integer> expectedPrimes = List.of();

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo2WithSundaram() {
        int maxValue = 2;
        Algorithm algo = Algorithm.SUNDARAM;
        List<Integer> expectedPrimes = List.of(2);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo10WithSundaram() {
        int maxValue = 10;
        Algorithm algo = Algorithm.SUNDARAM;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo11WithSundaram() {
        int maxValue = 11;
        Algorithm algo = Algorithm.SUNDARAM;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo100WithSundaram() {
        int maxValue = 100;
        Algorithm algo = Algorithm.SUNDARAM;
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo1WithAtkin() {
        int maxValue = 1;
        Algorithm algo = Algorithm.ATKIN;
        List<Integer> expectedPrimes = List.of();

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo2WithAtkin() {
        int maxValue = 2;
        Algorithm algo = Algorithm.ATKIN;
        List<Integer> expectedPrimes = List.of(2);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo10WithAtkin() {
        int maxValue = 10;
        Algorithm algo = Algorithm.ATKIN;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo11WithAtkin() {
        int maxValue = 11;
        Algorithm algo = Algorithm.ATKIN;
        List<Integer> expectedPrimes = List.of(2, 3, 5, 7, 11);

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

    @Test
    public void testCalculatePrimeNumbersUpTo100WithAtkin() {
        int maxValue = 100;
        Algorithm algo = Algorithm.ATKIN;
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );

        PrimesDTO result = primeService.calculatePrimeNumbersUpTo(maxValue, algo);

        assertEquals(algo.getName(), result.algorithm());
        assertEquals(expectedPrimes, result.primes());
    }

}
