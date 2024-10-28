package com.example.calculator.prime.demo.enums;

import lombok.Getter;

@Getter
public enum Algorithm {

    ERATOSTHENES("Sieve of Eratosthenes"),
    SUNDARAM("Sieve of Sundaram"),
    ATKIN("Sieve of Atkin");

    public final String name;

    Algorithm(String name) {
        this.name = name;
    }

}
