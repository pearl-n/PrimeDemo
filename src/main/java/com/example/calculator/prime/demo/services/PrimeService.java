package com.example.calculator.prime.demo.services;

import com.example.calculator.prime.demo.response.PrimesResponse;
import com.example.calculator.prime.demo.enums.Algorithm;

public interface PrimeService {

    PrimesResponse calculatePrimeNumbersUpTo(int maxValue, Algorithm algo);

}
