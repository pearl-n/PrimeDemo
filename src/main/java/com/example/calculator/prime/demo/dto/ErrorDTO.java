package com.example.calculator.prime.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ErrorDTO(
        @Schema(description = "The error message")
        String message,
        @Schema(description = "Some additional details about the error")
        List<String> details,
        @Schema(description = "The service where the error originated", example = "prime-demo")
        String source,
        @Schema(description = "The timestamp of the error")
        LocalDateTime timestamp
) {
}
