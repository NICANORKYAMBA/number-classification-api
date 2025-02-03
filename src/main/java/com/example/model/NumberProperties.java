package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberProperties {
    private String number;
    private Boolean is_prime;
    private Boolean is_perfect;
    private String[] properties;
    private Integer digit_sum;
    private String fun_fact;
    private Boolean error; // Use Boolean to allow null values

    public NumberProperties(int number, boolean is_prime, boolean is_perfect, String[] properties, int digit_sum, String fun_fact) {
        this.number = String.valueOf(number);
        this.is_prime = is_prime;
        this.is_perfect = is_perfect;
        this.properties = properties;
        this.digit_sum = digit_sum;
        this.fun_fact = fun_fact;
        this.error = null; // Set to null for valid numbers
    }

    public NumberProperties(String number, boolean error) {
        this.number = number; // Invalid number
        this.is_prime = null;
        this.is_perfect = null;
        this.properties = null;
        this.digit_sum = null;
        this.fun_fact = null;
        this.error = error;
    }

    public String getNumber() {
        return number;
    }

    public Boolean getIs_prime() {
        return is_prime;
    }

    public Boolean getIs_perfect() {
        return is_perfect;
    }

    public String[] getProperties() {
        return properties;
    }

    public Integer getDigit_sum() {
        return digit_sum;
    }

    public String getFun_fact() {
        return fun_fact;
    }

    public Boolean getError() {
        return error;
    }
}