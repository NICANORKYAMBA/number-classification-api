package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.model.NumberProperties;
import com.example.util.NumberUtils;

@Service
public class NumberClassificationService {

    @Value("${fun.fact.api.url}")
    private String funFactApiUrl;

    public NumberProperties classifyNumber(int number) {
        boolean is_prime = NumberUtils.isPrime(number);
        boolean is_perfect = NumberUtils.isPerfect(number);
        String[] properties = NumberUtils.getProperties(number);
        int digit_sum = NumberUtils.getDigitSum(number);
        String fun_fact = getFunFact(number);

        return new NumberProperties(number, is_prime, is_perfect, properties, digit_sum, fun_fact);
    }

    private String getFunFact(int number) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(funFactApiUrl + number + "/math", String.class);
        } catch (RestClientException e) {
            return "Fun fact not available";
        }
    }
}