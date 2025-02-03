package com.example.controller;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.model.NumberProperties;
import com.example.service.NumberClassificationService;

@WebMvcTest(NumberClassificationController.class)
public class NumberClassificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumberClassificationService numberClassificationService;

    @Test
    public void classifyNumber_validNumber_returnsProperties() throws Exception {
        NumberProperties properties = new NumberProperties(371, false, false, new String[]{"armstrong", "odd"}, 11, "371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371");
        Mockito.when(numberClassificationService.classifyNumber(371)).thenReturn(properties);

        mockMvc.perform(get("/api/classify-number")
                .param("number", "371")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number", is("371")))
                .andExpect(jsonPath("$.is_prime", is(false)))
                .andExpect(jsonPath("$.is_perfect", is(false)))
                .andExpect(jsonPath("$.properties[0]", is("armstrong")))
                .andExpect(jsonPath("$.properties[1]", is("odd")))
                .andExpect(jsonPath("$.digit_sum", is(11)))
                .andExpect(jsonPath("$.fun_fact", is("371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371")));
    }

    @Test
    public void classifyNumber_invalidNumber_returnsError() throws Exception {
        mockMvc.perform(get("/api/classify-number")
                .param("number", "alphabet")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.number", is("alphabet")))
                .andExpect(jsonPath("$.error", is(true)));
    }
}