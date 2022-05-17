package dev.lotnest.flightapp.service.impl;

import dev.lotnest.flightapp.dto.AccountDto;
import dev.lotnest.flightapp.model.Account;
import dev.lotnest.flightapp.repository.AccountRepository;
import dev.lotnest.flightapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account addAccount(AccountDto accountDto) {
        Account result = new Account();

        result.setUsername(accountDto.getUsername());
        result.setPassword(accountDto.getPassword());
        result.setPasswordConfirmation(accountDto.getPasswordConfirmation());
        result.setEmail(accountDto.getEmail());

        return accountRepository.save(result);
    }
}
