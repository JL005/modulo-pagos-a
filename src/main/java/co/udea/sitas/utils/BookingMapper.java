package co.udea.sitas.utils;

import java.util.List;
import java.util.stream.Collectors;

import co.udea.sitas.dto.BookingDTO;
import co.udea.sitas.model.Booking;

public class BookingMapper {

    private BookingMapper() {
    }

    public static BookingDTO toDTO(Booking booking){
        return BookingDTO.builder()
                .bookingId(booking.getBookingId())
                .passengerId(booking.getPassengerId())
                .flightId(booking.getFlightId())
                .bookingDate(booking.getBookingDate())
                .basePrice(booking.getBasePrice())
                .tax(booking.getTax())
                .totalPrice(booking.getTotalPrice())
                .isPaid(booking.isPaid())
                .build();
    }


    public static List<BookingDTO> toDTOList(List<Booking> bookings){
        return bookings.stream().map(BookingMapper::toDTO).toList();
    }
}
