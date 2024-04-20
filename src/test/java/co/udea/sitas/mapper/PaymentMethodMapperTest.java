package co.udea.sitas.mapper;

import co.udea.sitas.dto.PaymentMethodDTO;
import co.udea.sitas.model.PaymentMethod;
import co.udea.sitas.utils.PaymentMethodMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PaymentMethodMapperTest {
    @Test
    public void testToDTO() {
        // Arrange
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(1L);
        paymentMethod.setName("Credit Card");

        // Act
        PaymentMethodDTO dto = PaymentMethodMapper.toDTO(paymentMethod);

        // Assert
        assertEquals(paymentMethod.getId(), dto.getId());
        assertEquals(paymentMethod.getName(), dto.getName());
    }
}

