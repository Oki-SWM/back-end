package com.example.oki.message;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Message {

    private HttpStatus status;
    private String message;
    private Object data;

    public Message(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}