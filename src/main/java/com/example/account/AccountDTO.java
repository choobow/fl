package com.example.account;

import lombok.Data;

@Data
public class AccountDTO {
    private String id;
    private String password;
    private String newPassword;
}
