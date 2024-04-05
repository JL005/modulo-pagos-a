package co.udea.sitas.Service;

import co.udea.sitas.Model.Booking;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final String filePath = "classpath:bookings.json";

    public List<List<Booking>> searchBookingsByID(int booking_id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("bookings.json");

            if(inputStream != null) {
                Booking[] bookings = objectMapper.readValue(inputStream, Booking[].class);
                return Arrays.asList(
                        Arrays.stream(bookings)
                                .filter(booking -> isBookingInBookings(booking.getBookingId(), booking_id))
                                .collect(Collectors.toList()));
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo el archivo JSON ", e);
        }
    }

    private boolean isBookingInBookings(int bookingtocheck, int booking) {
        // Checks if booking_id is in Bookings list
        return Objects.equals(bookingtocheck, booking);
    }

}
