package co.udea.sitas.Controller;
import co.udea.sitas.Model.PaymentMethod.CreditCard;
import co.udea.sitas.Model.PaymentMethod.SavingsCard;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paymentmethod")
public class BankController {
    @PostMapping("/creditcard")
    public String makePayment(@RequestBody CreditCard creditCard) {

        return "Pago realizado exitosamente";
    }

    @PostMapping("/savingscard")
    public String makePayment(@RequestBody SavingsCard savingsCard) {

        return "Pago realizado exitosamente";
    }
}


