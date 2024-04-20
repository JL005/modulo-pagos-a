package co.udea.sitas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paypal_account")
@Getter
@Setter
public class PaypalAccount {
    @Id
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "password")
    private String password;
}
