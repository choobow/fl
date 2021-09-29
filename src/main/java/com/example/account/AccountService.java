package com.example.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 보일러 플레이트가 많지만 간단하게 구현해보았습니다.
 */

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public String create(AccountDTO accountDTO) {
        Account account = Account.builder()
                .id(accountDTO.getId())
                .password(accountDTO.getPassword())
                .build();

        accountRepository.save(account);

        return accountDTO.getId();
    }

    @Transactional
    public void updatePassword(AccountDTO accountDTO) {
        if(!accountRepository.findByIdAndPasswordEquals(accountDTO.getId(), accountDTO.getPassword()).isPresent()) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
        }

        Account account = Account.builder()
                .id(accountDTO.getId())
                .password(accountDTO.getNewPassword())
                .build();

        accountRepository.save(account);
    }

    @Transactional
    public String remove(AccountDTO accountDTO) {
        Account account = Account.builder()
                .id(accountDTO.getId())
                .password(accountDTO.getPassword())
                .build();

        accountRepository.delete(account);

        return accountDTO.getId();
    }
}
