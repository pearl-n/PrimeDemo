package com.example.calculator.prime.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Builder;

import java.util.List;

@Builder
@XmlRootElement
public record PrimesDTO(
        @Schema(description = "The name of the algorithm used", example = "Sieve of Eratosthenes")
        String algorithm,
        @Schema(description = "A list of prime numbers up to and including the given max value", example = "[2,3,5,7,11]")
        List<Integer> primes
) {
}
