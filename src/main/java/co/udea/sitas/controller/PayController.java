package co.udea.sitas.controller;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paymentmethod")
public class PayController {

    private final PaymentService paymentService;

    @PostMapping("/card/")
    public CardPaidDTO makePayment(@RequestBody PayCardDTO payCreditCard) {
        return this.paymentService.payBookingWithCard(payCreditCard);
    }


}

