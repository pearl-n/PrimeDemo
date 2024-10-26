package com.example.calculator.prime.demo.services;

import com.example.calculator.prime.demo.dto.PrimesDTO;
import com.example.calculator.prime.demo.enums.Algorithm;

public interface PrimeService {

    PrimesDTO calculatePrimeNumbersUpTo(int maxValue, Algorithm algo);

}
