package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.NumberProperties;
import com.example.service.NumberClassificationService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class NumberClassificationController {

    @Autowired
    private NumberClassificationService numberClassificationService;

    @GetMapping("/classify-number")
    public ResponseEntity<NumberProperties> classifyNumber(@RequestParam(required = false) String number) {
        if (number == null || number.isEmpty()) {
            NumberProperties errorResponse = new NumberProperties("alphabet", true);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        try {
            int num = Integer.parseInt(number);
            NumberProperties properties = numberClassificationService.classifyNumber(num);
            return new ResponseEntity<>(properties, HttpStatus.OK);
        } catch (NumberFormatException e) {
            NumberProperties errorResponse = new NumberProperties(number, true);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}