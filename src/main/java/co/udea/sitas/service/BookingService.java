package co.udea.sitas.service;

import co.udea.sitas.dto.BookingDTO;
import co.udea.sitas.model.Booking;
import co.udea.sitas.repository.BookingRepository;
import co.udea.sitas.utils.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingDTO getBookingByID(long bookingId) {
        Booking booking = this.bookingRepository.findById(bookingId).orElse(null);
        if (booking == null) {
            return null;
        }
        return BookingMapper.toDTO(booking);
    }

    public Booking paidBooking(long bookingId) throws SQLDataException {
        Booking booking = this.bookingRepository.findById(bookingId).orElse(null);
        if (booking == null) {
            throw new SQLDataException("Booking not found");
        }
        if (booking.isPaid()) {
            throw new SQLDataException("Booking already paid");
        }
        booking.setPaid(true);
        this.bookingRepository.save(booking);
        return booking;
    }

    public List<BookingDTO> getUnpaidBookings() {
        List<Booking> bookings = this.bookingRepository.findByIsPaidFalse();
        return BookingMapper.toDTOList(bookings);
    }

}
