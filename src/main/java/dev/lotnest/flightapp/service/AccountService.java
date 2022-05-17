package dev.lotnest.flightapp.service;

import dev.lotnest.flightapp.dto.AccountDto;
import dev.lotnest.flightapp.model.Account;

public interface AccountService {

    Account addAccount(AccountDto accountDto);
}
