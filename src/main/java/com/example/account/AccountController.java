package com.example.account;

import com.example.common.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/api/v1/accounts")
    public AccountResponse create(@RequestBody @Valid AccountDTO account) {
        return new AccountResponse(accountService.create(account));
    }

    @PutMapping("/api/v1/accounts/password")
    public String updatePassword(@RequestBody @Valid AccountDTO account) {
        accountService.updatePassword(account);
        return "비밀번호 변경";
    }

    @DeleteMapping("/api/v1/accounts")
    public AccountResponse delete(@RequestBody @Valid AccountDTO account) {
        return new AccountResponse(accountService.remove(account));
    }

}
