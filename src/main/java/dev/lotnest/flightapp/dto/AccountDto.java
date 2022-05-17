package dev.lotnest.flightapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
}
