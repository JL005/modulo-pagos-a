package co.udea.sitas.service;

import co.udea.sitas.dto.CardPaidDTO;
import co.udea.sitas.dto.PayCardDTO;
import co.udea.sitas.dto.PaypalDTO;
import co.udea.sitas.model.Booking;
import co.udea.sitas.model.PaypalAccount;
import co.udea.sitas.repository.PaypalAccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLDataException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PaymentServiceTest {

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
    public void testPayBookingWithCard() throws SQLDataException {
        // Arrange
        PayCardDTO payCardDTO = new PayCardDTO();
        payCardDTO.setCardNumber("4111111111111111");
        payCardDTO.setBookingId(1L);

        Booking booking = new Booking();
        booking.setTotalPrice(100.0);
        when(bookingService.paidBooking(1L)).thenReturn(booking);

        // Act
        CardPaidDTO cardPaidDTO = paymentService.payBookingWithCard(payCardDTO);

        // Assert
        assertEquals("VISA", cardPaidDTO.getCardType());
        verify(bookingService, times(1)).paidBooking(1L);
    }

    @Test
    public void testValidateCard_Visa() {
        // Arrange
        PayCardDTO payCardDTO = new PayCardDTO();
        payCardDTO.setCardNumber("4111111111111111");

        // Act
        String cardType = paymentService.validateCard(payCardDTO);

        // Assert
        assertEquals("VISA", cardType);
    }

    @Test
    public void testValidateCard_Unknown() {
        // Arrange
        PayCardDTO payCardDTO = new PayCardDTO();
        payCardDTO.setCardNumber("1234567890123456");

        // Act
        String cardType = paymentService.validateCard(payCardDTO);

        // Assert
        assertEquals(null, cardType);
    }

    // Similar tests can be written for isMastercard and isAmericanExpress methods

    @Test
    public void testPayPalPayment_ValidAccount() {
        // Arrange
        PaypalDTO paypalDTO = new PaypalDTO();
        paypalDTO.setEmail("test@example.com");
        paypalDTO.setPassword("password");

        PaypalAccount mockAccount = new PaypalAccount();
        mockAccount.setEmail("test@example.com");
        mockAccount.setPassword("password");
        when(paypalAccountRepository.findByEmail("test@example.com")).thenReturn(mockAccount);

        // Act
        boolean result = paymentService.payPalPayment(paypalDTO);

        // Assert
        assertEquals(true, result);
    }

    @Test
    public void testPayPalPayment_InvalidAccount() {
        // Arrange
        PaypalDTO paypalDTO = new PaypalDTO();
        paypalDTO.setEmail("test@example.com");
        paypalDTO.setPassword("password");

        when(paypalAccountRepository.findByEmail("test@example.com")).thenReturn(null);

        // Act
        boolean result = paymentService.payPalPayment(paypalDTO);

        // Assert
        assertEquals(false, result);
    }
}
