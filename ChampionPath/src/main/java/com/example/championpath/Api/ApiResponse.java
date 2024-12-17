package com.example.championpath.Api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class ApiResponse {
    private String message;
    public ApiResponse(String message){
        this.message = message;
    }
}
