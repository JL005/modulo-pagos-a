package co.udea.sitas.controller;

import co.udea.sitas.dto.PaymentMethodDTO;
import co.udea.sitas.service.PaymentMethodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Métodos de pago", description = "API que permite consultar los métodos de pagos disponibles")
@RestController
@RequestMapping("/paymentmethods")
@RequiredArgsConstructor
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @Operation(summary = "Obtener métodos de pago", description = "Se obtiene un listado de todos los métodos de pago disponibles en el sistema")
    @GetMapping("/")
    public ResponseEntity<List<PaymentMethodDTO>> getAllPaymentMethods() {
        try {
            return new ResponseEntity<>(this.paymentMethodService.getAllPaymentMethods(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
