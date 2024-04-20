package co.udea.sitas.utils;

import co.udea.sitas.dto.PaymentMethodDTO;
import co.udea.sitas.model.PaymentMethod;

public class PaymentMethodMapper {

    private PaymentMethodMapper() {
    }

    public static PaymentMethodDTO toDTO(PaymentMethod paymentMethod) {
         return PaymentMethodDTO.builder()
                .id(paymentMethod.getId())
                .name(paymentMethod.getName())
                .build();
    }

}
