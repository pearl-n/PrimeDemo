package com.example.calculator.prime.demo.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class PrimesResponse {

        @Schema(description = "The name of the algorithm used", example = "Sieve of Eratosthenes")
        String algorithm;

        @Schema(description = "A list of prime numbers up to and including the given max value", example = "[2,3,5,7,11]")
        List<Integer> primes;

}