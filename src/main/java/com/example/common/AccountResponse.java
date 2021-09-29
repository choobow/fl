package com.example.common;

import lombok.Data;

@Data
public class AccountResponse {

    private String id;

    public AccountResponse(String id) {
        this.id = id;
    }
}
