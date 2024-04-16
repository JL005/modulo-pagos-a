package co.udea.sitas.controller;

import co.udea.sitas.dto.PaymentMethodDTO;
import co.udea.sitas.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paymentmethods")
@RequiredArgsConstructor
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping("/")
    public ResponseEntity<List<PaymentMethodDTO>> getAllPaymentMethods() {
        try {
            return new ResponseEntity<>(this.paymentMethodService.getAllPaymentMethods(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
