package com.example.calculator.prime.demo.utility;

import com.example.calculator.prime.demo.enums.Algorithm;
import com.example.calculator.prime.demo.response.PrimesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.Arrays;
import java.util.List;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class FormatUtilTests {

    @Test
    void testConvertObjectToPrettyJsonString_withSimpleObject() throws JsonProcessingException, JSONException {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11);
        PrimesResponse primesResponse = new PrimesResponse(Algorithm.ERATOSTHENES.getName(), primes);

        String actualString = FormatUtils.convertObjectToPrettyJsonString(primesResponse);

        String expectedString = """
            {
              "algorithm" : "Sieve of Eratosthenes",
              "primes" : [ 2, 3, 5, 7, 11 ]
            }""";
        assertEquals(expectedString, actualString, true);
    }

}
