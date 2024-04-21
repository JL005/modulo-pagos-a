package co.udea.sitas.service;

import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.dto.PaypalDTO;
import co.udea.sitas.repository.PaypalAccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLDataException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PaymentServiceTest {

    @Mock
    private BookingService bookingService;

    @Mock
    private PaymentMethodService paymentMethodService;

    @Mock
    private PaypalAccountRepository paypalAccountRepository;

    @InjectMocks
    private PaymentService paymentService;

    public PaymentServiceTest() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testValidateCard_Visa() {
        // Arrange
        PayCardDTO payCardDTO = new PayCardDTO();
        payCardDTO.setCardNumber("4111111111111111");
        // Act
        String cardType = paymentService.validateCard(payCardDTO);
        // Assert
        assertEquals("VISA", cardType);
    }

    @Test
    void testValidateCard_AmericanExpress() {
        // Arrange
        PayCardDTO payCardDTO = new PayCardDTO();
        payCardDTO.setCardNumber("378282246310005");
        // Act
        String cardType = paymentService.validateCard(payCardDTO);
        // Assert
        assertEquals("American Express", cardType);
    }

    @Test
    void testValidateCard_MasterCard() {
        // Arrange
        PayCardDTO payCardDTO = new PayCardDTO();
        payCardDTO.setCardNumber("5121111111111111");
        // Act
        String cardType = paymentService.validateCard(payCardDTO);
        // Assert
        assertEquals("Mastercard", cardType);
    }
    @Test
    void testValidateCard_Unknown() {
        // Arrange
        PayCardDTO payCardDTO = new PayCardDTO();
        payCardDTO.setCardNumber("1234567890123456");
        // Act
        String cardType = paymentService.validateCard(payCardDTO);
        // Assert
        assertNull(cardType);
    }

    @Test
    void testPayPalPayment_InvalidAccount() throws SQLDataException {
        // Arrange
        PaypalDTO paypalDTO = new PaypalDTO();
        paypalDTO.setEmail("test@example.com");
        paypalDTO.setPassword("password");

        when(paypalAccountRepository.findByEmail("test@example.com")).thenReturn(null);

        // Act
        boolean result = paymentService.payPalPayment(paypalDTO);

        // Assert
        assertFalse(result);
    }
}
