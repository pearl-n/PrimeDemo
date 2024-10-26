package com.example.calculator.prime.demo.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeUtils {

    public static List<Integer> basic(int maxValue) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxValue; i++) {
            boolean isPrime = true;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static List<Integer> eratosthenes(int maxValue) {
        boolean[] isPrime = new boolean[maxValue + 1]; // inclusive
        for (int i = 2; i <= maxValue; i++) { // start at prime 2
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(maxValue); i++) {
            if (isPrime[i]) { // if number needs to be checked
                int num = i * i;
                while (num <= maxValue) {
                    isPrime[num] = false;
                    num += i; // increment in multiples
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= maxValue; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static List<Integer> sundaram(int maxValue) {
        return List.of();
    }

    public static List<Integer> atkin(int maxValue) {
        return List.of();
    }

}
