package co.udea.sitas.service;

import co.udea.sitas.dto.PaymentMethodDTO;
import co.udea.sitas.model.PaymentMethod;
import co.udea.sitas.repository.PaymentMethodRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentMethodServiceTest {

    @Mock
    private PaymentMethodRepository paymentMethodRepository;

    @InjectMocks
    private PaymentMethodService paymentMethodService;

    public PaymentMethodServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPaymentMethods_Success() throws SQLDataException {
        // Arrange
        PaymentMethod paymentMethod1 = new PaymentMethod(1L, "Card");
        PaymentMethod paymentMethod2 = new PaymentMethod(2L, "PayPal");
        List<PaymentMethod> paymentMethods = Arrays.asList(paymentMethod1, paymentMethod2);

        when(paymentMethodRepository.findAll()).thenReturn(paymentMethods);

        // Act
        List<PaymentMethodDTO> paymentMethodDTOList = paymentMethodService.getAllPaymentMethods();

        // Assert
        assertNotNull(paymentMethodDTOList);
        assertEquals(paymentMethods.size(), paymentMethodDTOList.size());
        assertEquals(paymentMethod1.getId(), paymentMethodDTOList.get(0).getId());
        assertEquals(paymentMethod1.getName(), paymentMethodDTOList.get(0).getName());
        assertEquals(paymentMethod2.getId(), paymentMethodDTOList.get(1).getId());
        assertEquals(paymentMethod2.getName(), paymentMethodDTOList.get(1).getName());
        verify(paymentMethodRepository, times(1)).findAll();
    }

    @Test
    void testGetAllPaymentMethods_Exception() {
        // Arrange
        when(paymentMethodRepository.findAll()).thenThrow(new RuntimeException("Database error"));

        // Act/Assert
        assertThrows(SQLDataException.class, () -> paymentMethodService.getAllPaymentMethods());
    }

    @Test
    void testGetAllPaymentMethods_EmptyList() throws SQLDataException {
        // Arrange
        when(paymentMethodRepository.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<PaymentMethodDTO> paymentMethodDTOList = paymentMethodService.getAllPaymentMethods();

        // Assert
        assertNotNull(paymentMethodDTOList);
        assertTrue(paymentMethodDTOList.isEmpty());
        verify(paymentMethodRepository, times(1)).findAll();
    }
}
