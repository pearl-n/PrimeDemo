package com.example.calculator.prime.demo.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class ErrorResponse {

        @Schema(description = "The error message")
        String message;

        @Schema(description = "Some additional details about the error")
        List<String> details;

        @Schema(description = "The service where the error originated", example = "prime-demo")
        String source;

        @Schema(description = "The timestamp of the error")
        LocalDateTime timestamp;

}
