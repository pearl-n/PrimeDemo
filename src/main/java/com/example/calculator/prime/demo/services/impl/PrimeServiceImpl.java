package com.example.calculator.prime.demo.services.impl;

import com.example.calculator.prime.demo.dto.PrimesDTO;
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
    public PrimesDTO calculatePrimeNumbersUpTo(int maxValue, Algorithm algo) {
        long startTime = System.currentTimeMillis();
        List<Integer> primes = switch (algo) {
            case ERATOSTHENES -> PrimeUtils.eratosthenes(maxValue);
            case SUNDARAM -> PrimeUtils.sundaram(maxValue);
            case ATKIN -> PrimeUtils.atkin(maxValue);
            default -> PrimeUtils.basic(maxValue);
        };
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        return new PrimesDTO(duration, primes);
    }

}
