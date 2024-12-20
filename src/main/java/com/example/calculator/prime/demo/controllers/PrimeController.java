package com.example.calculator.prime.demo.controllers;

import com.example.calculator.prime.demo.response.PrimesResponse;
import com.example.calculator.prime.demo.enums.Algorithm;
import com.example.calculator.prime.demo.response.ErrorResponse;
import com.example.calculator.prime.demo.services.PrimeService;
import com.example.calculator.prime.demo.utility.FormatUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Validated
@Tag(name = "Primes", description = "Endpoints related to prime numbers")
public class PrimeController {

    private final PrimeService primeService;

    @Autowired
    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @Operation(summary = "Find prime numbers", description = "Calculates and returns all the prime numbers up to and including the number provided")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prime numbers successfully returned", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PrimesResponse.class)),
                    @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = PrimesResponse.class)),
                    @Content(mediaType = MediaType.TEXT_PLAIN_VALUE, schema = @Schema(implementation = PrimesResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request", content =
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "406", description = "No acceptable representation", content =
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Something unexpected occurred", content =
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/primes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findPrimes(
            @Parameter(description = "The maximum value of the prime numbers to be returned", example = "100")
            @RequestParam(value = "maxValue") @Valid @Min(0) @Max(Integer.MAX_VALUE) int maxValue,
            @Parameter(description = "The algorithm to be used")
            @RequestParam(value = "algorithm", required = false, defaultValue = "ERATOSTHENES") Algorithm algo) {
        PrimesResponse primes = primeService.calculatePrimeNumbersUpTo(maxValue, algo);
        return ResponseEntity.ok(primes);
    }

    @Operation(summary = "Find prime numbers", description = "Calculates and returns all the prime numbers up to and including the number provided")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prime numbers successfully returned", content = {
                    @Content(mediaType = MediaType.TEXT_PLAIN_VALUE, schema = @Schema(implementation = PrimesResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request", content =
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "406", description = "No acceptable representation", content =
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Something unexpected occurred", content =
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/primes", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> findPrimesText(
            @Parameter(description = "The maximum value of the prime numbers to be returned", example = "100")
            @RequestParam(value = "maxValue") @Valid @Min(0) @Max(Integer.MAX_VALUE) int maxValue,
            @Parameter(description = "The algorithm to be used")
            @RequestParam(value = "algorithm", required = false, defaultValue = "ERATOSTHENES") Algorithm algo) throws JsonProcessingException {
        PrimesResponse primes = primeService.calculatePrimeNumbersUpTo(maxValue, algo);
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(FormatUtils.convertObjectToPrettyJsonString(primes));
    }

}
