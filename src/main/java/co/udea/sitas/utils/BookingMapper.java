package co.udea.sitas.utils;

import co.udea.sitas.dto.BookingDTO;
import co.udea.sitas.model.Booking;

public class BookingMapper {

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


    public static Booking toEntity(BookingDTO bookingDTO){
        return Booking.builder()
                .bookingId(bookingDTO.getBookingId())
                .passengerId(bookingDTO.getPassengerId())
                .flightId(bookingDTO.getFlightId())
                .bookingDate(bookingDTO.getBookingDate())
                .basePrice(bookingDTO.getBasePrice())
                .tax(bookingDTO.getTax())
                .totalPrice(bookingDTO.getTotalPrice())
                .isPaid(bookingDTO.isPaid())
                .build();
    }
}
