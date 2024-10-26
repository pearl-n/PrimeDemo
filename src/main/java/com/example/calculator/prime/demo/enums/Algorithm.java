package com.example.calculator.prime.demo.enums;

public enum Algorithm {
    BASIC("Basic"),
    ERATOSTHENES("Sieve of Eratosthenes"),
    SUNDARAM("Sieve of Sundaram"),
    ATKIN("Sieve of Atkin");

    public final String name;

    Algorithm(String name) {
        this.name = name;
    }

}
