package co.udea.sitas.controller;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.dto.PaypalDTO;
import co.udea.sitas.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLDataException;

@Tag(name = "Pagos de reservas", description = "API que permite realizar pagos de las reservas disponibles")
@RequiredArgsConstructor
@RestController
@RequestMapping("/paymentmethod")
public class PayController {

    private final PaymentService paymentService;

    @Operation(summary = "Realizar pago con tarjeta de crédito", description = "Se ingresa la información de la tarjeta de crédito para pagar la reserva")
    @PostMapping("/card")
    public CardPaidDTO makePayment(@RequestBody PayCardDTO payCreditCard) throws SQLDataException {
        return this.paymentService.payBookingWithCard(payCreditCard);
    }


    @Operation(summary = "Realizar pago con PayPal", description = "Se ingresa la información de la cuenta de Paypal para pagar la reserva")
    @PostMapping("/paypal")
    public ResponseEntity<String> makePaymentPaypal(@RequestBody PaypalDTO paypalDTO) throws SQLDataException {
        if (this.paymentService.payPalPayment(paypalDTO)){
            return ResponseEntity.ok("Pago exitoso");
        }
        return ResponseEntity.notFound().build();

    }


}


