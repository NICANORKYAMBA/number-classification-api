package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DefaultController {

    @GetMapping("/")
    public ResponseEntity<MessageResponse> home() {
        MessageResponse message = new MessageResponse("Welcome to the Number Classification API. Use the /api/classify-number endpoint to classify a number.");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    private static class MessageResponse {
        private String message;

        public MessageResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}