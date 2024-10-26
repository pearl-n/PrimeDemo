package com.example.calculator.prime.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record PrimesDTO(
        @Schema(description = "Time taken (ms) to calculate prime numbers", example = "12345")
        double timeTakenInMillis,
        @Schema(description = "A list of prime numbers up to and including the given max value")
        List<Integer> primes
) {
}
