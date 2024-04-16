package co.udea.sitas.controller;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.dto.PayCreditCardDTO;
import co.udea.sitas.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paymentmethod")
public class PayController {

    private final PaymentService paymentService;

    @PostMapping("/creditcard/")
    public CardPaidDTO makePayment(@RequestBody PayCreditCardDTO payCreditCard) {
        return this.paymentService.payBookingWithCard(payCreditCard);
    }

    @PostMapping("/savingcard/")
    public CardPaidDTO makePayment(@RequestBody PayCardDTO payCreditCard) {
        return this.paymentService.payBookingWithCard(payCreditCard);
    }

}


