package co.udea.sitas.service;

import co.udea.sitas.dto.PaymentMethodDTO;
import co.udea.sitas.model.paymentmethod.PaymentMethod;
import co.udea.sitas.repository.PaymentMethodRepository;
import co.udea.sitas.utils.PaymentMethodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethodDTO> getAllPaymentMethods() {

        try {
            List<PaymentMethodDTO> paymentMethodDTOList = new ArrayList<>();
            for (PaymentMethod paymentMethod : this.paymentMethodRepository.findAll()) {
                PaymentMethodDTO paymentMethodDTO = PaymentMethodMapper.toDTO(paymentMethod);
                paymentMethodDTOList.add(paymentMethodDTO);
            }
            return paymentMethodDTOList;
        } catch (Exception e) {
            return null;
        }
    }
}
