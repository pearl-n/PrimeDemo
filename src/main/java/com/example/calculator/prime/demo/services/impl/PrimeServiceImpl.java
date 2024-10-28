package com.example.calculator.prime.demo.services.impl;

import com.example.calculator.prime.demo.response.PrimesResponse;
import com.example.calculator.prime.demo.enums.Algorithm;
import com.example.calculator.prime.demo.services.PrimeService;
import com.example.calculator.prime.demo.utility.PrimeUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimeServiceImpl implements PrimeService {

    @Override
    @Cacheable("primes")
    public PrimesResponse calculatePrimeNumbersUpTo(int maxValue, Algorithm algo) {
        List<Integer> primes = switch (algo) {
            case ERATOSTHENES -> PrimeUtils.eratosthenes(maxValue);
            case SUNDARAM -> PrimeUtils.sundaram(maxValue);
            case ATKIN -> PrimeUtils.atkin(maxValue);
        };
        return new PrimesResponse(algo.getName(), primes);
    }

}
