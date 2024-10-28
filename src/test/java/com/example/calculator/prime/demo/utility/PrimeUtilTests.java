package com.example.calculator.prime.demo.utility;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeUtilTests {

    @Test
    public void testEratosthenesWithMaxValue1() {
        List<Integer> expectedPrimes = List.of();
        assertEquals(expectedPrimes, PrimeUtils.eratosthenes(1), "Failed on maxValue=1");
    }

    @Test
    public void testEratosthenesWithMaxValue2() {
        List<Integer> expectedPrimes = List.of(2);
        assertEquals(expectedPrimes, PrimeUtils.eratosthenes(2), "Failed on maxValue=2");
    }

    @Test
    public void testEratosthenesWithMaxValue10() {
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        assertEquals(expectedPrimes, PrimeUtils.eratosthenes(10), "Failed on maxValue=10");
    }

    @Test
    public void testEratosthenesWithMaxValue11() {
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11);
        assertEquals(expectedPrimes, PrimeUtils.eratosthenes(11), "Failed on maxValue=11");
    }

    @Test
    public void testEratosthenesWithMaxValue100() {
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );
        assertEquals(expectedPrimes, PrimeUtils.eratosthenes(100), "Failed on maxValue=100");
    }

    @Test
    public void testSundaramWithMaxValue1() {
        List<Integer> expectedPrimes = List.of();
        assertEquals(expectedPrimes, PrimeUtils.sundaram(1), "Failed on maxValue=1");
    }

    @Test
    public void testSundaramWithMaxValue2() {
        List<Integer> expectedPrimes = List.of(2);
        assertEquals(expectedPrimes, PrimeUtils.sundaram(2), "Failed on maxValue=2");
    }

    @Test
    public void testSundaramWithMaxValue10() {
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        assertEquals(expectedPrimes, PrimeUtils.sundaram(10), "Failed on maxValue=10");
    }

    @Test
    public void testSundaramWithMaxValue11() {
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11);
        assertEquals(expectedPrimes, PrimeUtils.sundaram(11), "Failed on maxValue=11");
    }

    @Test
    public void testSundaramWithMaxValue100() {
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );
        assertEquals(expectedPrimes, PrimeUtils.sundaram(100), "Failed on maxValue=100");
    }

    @Test
    public void testAtkinWithMaxValue1() {
        List<Integer> expectedPrimes = List.of();
        assertEquals(expectedPrimes, PrimeUtils.atkin(1), "Failed on maxValue=1");
    }

    @Test
    public void testAtkinWithMaxValue2() {
        List<Integer> expectedPrimes = List.of(2);
        assertEquals(expectedPrimes, PrimeUtils.atkin(2), "Failed on maxValue=2");
    }

    @Test
    public void testAtkinWithMaxValue10() {
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        assertEquals(expectedPrimes, PrimeUtils.atkin(10), "Failed on maxValue=10");
    }

    @Test
    public void testAtkinWithMaxValue11() {
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11);
        assertEquals(expectedPrimes, PrimeUtils.atkin(11), "Failed on maxValue=11");
    }

    @Test
    public void testAtkinWithMaxValue100() {
        List<Integer> expectedPrimes = Arrays.asList(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        );
        assertEquals(expectedPrimes, PrimeUtils.atkin(100), "Failed on maxValue=100");
    }

}
