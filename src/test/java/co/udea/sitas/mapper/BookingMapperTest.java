package co.udea.sitas.mapper;

import co.udea.sitas.dto.BookingDTO;
import co.udea.sitas.model.Booking;
import co.udea.sitas.utils.BookingMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookingMapperTest {
    @Test
    public void testToDTO() {
        // Arrange
        Booking booking = new Booking();
        booking.setBookingId(1L);
        booking.setPassengerId(1);
        booking.setFlightId(1);
        booking.setBookingDate("2024-04-20");
        booking.setBasePrice(100.0);
        booking.setTax(10.0);
        booking.setTotalPrice(110.0);
        booking.setPaid(true);

        // Act
        BookingDTO bookingDTO = BookingMapper.toDTO(booking);

        // Assert
        assertEquals(booking.getBookingId(), bookingDTO.getBookingId());
        assertEquals(booking.getPassengerId(), bookingDTO.getPassengerId());
        assertEquals(booking.getFlightId(), bookingDTO.getFlightId());
        assertEquals(booking.getBookingDate(), bookingDTO.getBookingDate());
        assertEquals(booking.getBasePrice(), bookingDTO.getBasePrice());
        assertEquals(booking.getTax(), bookingDTO.getTax());
        assertEquals(booking.getTotalPrice(), bookingDTO.getTotalPrice());
        assertEquals(booking.isPaid(), bookingDTO.isPaid());
    }

    @Test
    public void testToDTOList() {
        // Arrange
        List<Booking> bookings = Arrays.asList(
                new Booking(1L, 1,1, "2024-04-20", 100.0, 10.0, 110.0, true),
                new Booking(2L, 2, 2, "2024-04-21", 150.0, 15.0, 165.0, false)
        );

        // Act
        List<BookingDTO> bookingDTOList = BookingMapper.toDTOList(bookings);

        // Assert
        assertEquals(bookings.size(), bookingDTOList.size());
        assertEquals(bookings.get(0).getBookingId(), bookingDTOList.get(0).getBookingId());
        assertEquals(bookings.get(0).getPassengerId(), bookingDTOList.get(0).getPassengerId());
        assertEquals(bookings.get(0).getFlightId(), bookingDTOList.get(0).getFlightId());
        assertEquals(bookings.get(0).getBookingDate(), bookingDTOList.get(0).getBookingDate());
        assertEquals(bookings.get(0).getBasePrice(), bookingDTOList.get(0).getBasePrice());
        assertEquals(bookings.get(0).getTax(), bookingDTOList.get(0).getTax());
        assertEquals(bookings.get(0).getTotalPrice(), bookingDTOList.get(0).getTotalPrice());
        assertEquals(bookings.get(0).isPaid(), bookingDTOList.get(0).isPaid());

        assertEquals(bookings.get(1).getBookingId(), bookingDTOList.get(1).getBookingId());
        assertEquals(bookings.get(1).getPassengerId(), bookingDTOList.get(1).getPassengerId());
        assertEquals(bookings.get(1).getFlightId(), bookingDTOList.get(1).getFlightId());
        assertEquals(bookings.get(1).getBookingDate(), bookingDTOList.get(1).getBookingDate());
        assertEquals(bookings.get(1).getBasePrice(), bookingDTOList.get(1).getBasePrice());
        assertEquals(bookings.get(1).getTax(), bookingDTOList.get(1).getTax());
        assertEquals(bookings.get(1).getTotalPrice(), bookingDTOList.get(1).getTotalPrice());
        assertEquals(bookings.get(1).isPaid(), bookingDTOList.get(1).isPaid());
    }
}
