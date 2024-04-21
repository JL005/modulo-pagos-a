package co.udea.sitas.controller;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.dto.PaypalDTO;
import co.udea.sitas.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/paymentmethod")
public class PayController {

    private final PaymentService paymentService;

    @PostMapping("/card")
    public CardPaidDTO makePayment(@RequestBody PayCardDTO payCreditCard) throws SQLDataException {
        return this.paymentService.payBookingWithCard(payCreditCard);
    }


    @PostMapping("/paypal")
    public ResponseEntity<String> makePaymentPaypal(@RequestBody PaypalDTO paypalDTO) throws SQLDataException {
        if (this.paymentService.payPalPayment(paypalDTO)){
            return ResponseEntity.ok("Pago exitoso");
        }
        return ResponseEntity.notFound().build();

    }


}


