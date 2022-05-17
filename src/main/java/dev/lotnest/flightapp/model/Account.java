package dev.lotnest.flightapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
    private boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(username, account.username) && Objects.equals(email, account.email) && Objects.equals(password, account.password) && Objects.equals(passwordConfirmation, account.passwordConfirmation) && Objects.equals(enabled, account.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, passwordConfirmation, enabled);
    }
}
