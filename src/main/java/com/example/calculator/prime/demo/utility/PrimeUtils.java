package com.example.calculator.prime.demo.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeUtils {

    public static List<Integer> eratosthenes(int maxValue) {
        if (maxValue < 2) return new ArrayList<>(); // no primes less than 2

        int n = maxValue + 1; // inclusive range

        boolean[] isPrime = new boolean[n];
        isPrime[2] = true;
        for (int i = 3; i < n; i += 2) { // mark odd numbers as primes
            isPrime[i] = true;
        }

        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) { // if the number is marked as prime
                int j = i * i;
                while (j < n) {
                    isPrime[j] = false;
                    j += i; // increment in multiples
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) { // collect all prime numbers
            if (isPrime[i]) primes.add(i);
        }

        return primes;
    }

    public static List<Integer> sundaram(int maxValue) {
        if (maxValue < 2) return new ArrayList<>(); // no primes less than 2

        int k = (maxValue - 1) / 2; // int rounded down, divided by 2 bc we don't care about even numbers

        boolean[] isPrime = new boolean[k + 1];
        for (int i = 0; i <= k; i++) {
            isPrime[i] = true;
        }

        for (int i = 1; i <= k; i++) {
            int j = i;
            while (i + j + 2 * i * j <= k) { // non-prime
                isPrime[i + j + 2 * i * j] = false;
                j++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        primes.add(2); // prime 2

        for (int i = 1; i <= k; i++) {
            if (isPrime[i]) {
                int prime = 2 * i + 1; // convert indices to primes
                if (prime <= maxValue) { // only add primes up to maxValue
                    primes.add(prime);
                }
            }
        }

        return primes;
    }

    public static List<Integer> atkin(int maxValue) {
        if (maxValue < 2) return new ArrayList<>(); // no primes less than 2

        int n = maxValue + 1; // inclusive

        boolean[] isPrime = new boolean[n + 1];

        for (int x = 1; x * x <= n; x++) {
            for (int y = 1; y * y <= n; y += 2) {
                int m = 4 * x * x + y * y;
                if (m <= n && (m % 60 == 1 || m % 60 == 13 || m % 60 == 17 || m % 60 == 29 || m % 60 == 37 || m % 60 == 41 || m % 60 == 49 || m % 60 == 53)) {
                    isPrime[m] = !isPrime[m];
                }
            }
        }

        for (int x = 1; x * x <= n; x += 2) {
            for (int y = 2; y * y <= n; y += 2) {
                int m = 3 * x * x + y * y;
                if (m <= n && (m % 60 == 7 || m % 60 == 19 || m % 60 == 31 || m % 60 == 43)) {
                    isPrime[m] = !isPrime[m];
                }
            }
        }

        for (int x = 2; x * x <= n; x++) {
            for (int y = x - 1; y > 0; y -= 2) {
                int m = 3 * x * x - y * y;
                if (m <= n && (m % 60 == 11 || m % 60 == 23 || m % 60 == 47 || m % 60 == 59)) {
                    isPrime[m] = !isPrime[m];
                }
            }
        }

        for (int m = 5; m * m <= n; m++) {
            if (isPrime[m]) {
                int mm = m * m;
                for (int k = mm; k <= n; k += mm) {
                    isPrime[k] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();

        if (maxValue >= 2) primes.add(2);
        if (maxValue >= 3) primes.add(3);
        if (maxValue >= 5) primes.add(5);

        for (int i = 7; i <= n; i++) {
            if (isPrime[i]) {
                if (i <= maxValue) { // only add primes up to maxValue
                    primes.add(i);
                }
            }
        }

        return primes;
    }

}
