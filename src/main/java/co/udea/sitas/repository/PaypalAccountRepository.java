package co.udea.sitas.repository;

import co.udea.sitas.model.PaypalAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaypalAccountRepository extends JpaRepository<PaypalAccount, String> {
    PaypalAccount findByEmail(String email);
}
