package co.udea.sitas.controller;

import co.udea.sitas.dto.BookingDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import co.udea.sitas.service.BookingService;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;

    @GetMapping("/{bookingId}")
    public BookingDTO getBookingByID(@PathVariable(name = "bookingId") long bookingId) {
        return bookingService.getBookingByID(bookingId);
    }

    @GetMapping("/")
    public List<BookingDTO> getUnpaidBookings() {
        return bookingService.getUnpaidBookings();
    }
}

