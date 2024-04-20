package co.udea.sitas.service;

import co.udea.sitas.dto.BookingDTO;
import co.udea.sitas.model.Booking;
import co.udea.sitas.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLDataException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    public BookingServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookingByID_ValidBooking() {
        // Arrange
        long bookingId = 1L;
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Act
        BookingDTO bookingDTO = bookingService.getBookingByID(bookingId);

        // Assert
        assertNotNull(bookingDTO);
        assertEquals(bookingId, bookingDTO.getBookingId());
    }

    @Test
    void testGetBookingByID_InvalidBooking() {
        // Arrange
        long bookingId = 1L;
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.empty());

        // Act
        BookingDTO bookingDTO = bookingService.getBookingByID(bookingId);

        // Assert
        assertNull(bookingDTO);
    }

    @Test
    void testPaidBooking_SuccessfulPayment() throws SQLDataException {
        // Arrange
        long bookingId = 1L;
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        booking.setPaid(false);
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Act
        Booking result = bookingService.paidBooking(bookingId);

        // Assert
        assertNotNull(result);
        assertTrue(result.isPaid());
        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void testPaidBooking_BookingNotFound() {
        // Arrange
        long bookingId = 1L;
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.empty());

        // Act/Assert
        assertThrows(SQLDataException.class, () -> bookingService.paidBooking(bookingId));
    }

    @Test
    void testPaidBooking_AlreadyPaidBooking() {
        // Arrange
        long bookingId = 1L;
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        booking.setPaid(true);
        when(bookingRepository.findById(bookingId)).thenReturn(Optional.of(booking));

        // Act/Assert
        assertThrows(SQLDataException.class, () -> bookingService.paidBooking(bookingId));
    }

    @Test
    void testGetUnpaidBookings() {
        // Arrange
        Booking booking1 = new Booking();
        booking1.setBookingId(1L);
        booking1.setPaid(false);
        Booking booking2 = new Booking();
        booking2.setBookingId(2L);
        booking2.setPaid(true);
        List<Booking> unpaidBookings = List.of(booking1);

        when(bookingRepository.findByIsPaidFalse()).thenReturn(unpaidBookings);

        // Act
        List<BookingDTO> unpaidBookingsDTO = bookingService.getUnpaidBookings();

        // Assert
        assertEquals(1, unpaidBookingsDTO.size());
        assertEquals(booking1.getBookingId(), unpaidBookingsDTO.get(0).getBookingId());
    }
}
