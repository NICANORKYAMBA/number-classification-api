package com.example.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.example.model.NumberProperties;

@SpringBootTest
public class NumberClassificationServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void classifyNumber_returnsCorrectProperties() {
        NumberClassificationService service = new NumberClassificationService();
        Mockito.when(restTemplate.getForObject("http://numbersapi.com/371/math", String.class))
                .thenReturn("371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371");

        NumberProperties properties = service.classifyNumber(371);

        assertEquals("371", properties.getNumber());
        assertFalse(properties.getIs_prime());
        assertFalse(properties.getIs_perfect());
        assertArrayEquals(new String[]{"armstrong", "odd"}, properties.getProperties());
        assertEquals(11, properties.getDigit_sum());
        assertEquals("371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371", properties.getFun_fact());
    }
}