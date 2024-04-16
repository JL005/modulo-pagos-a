package co.udea.sitas.controller;

import co.udea.sitas.dto.BookingDTO;
import co.udea.sitas.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.udea.sitas.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;

    @GetMapping("/{bookingId}")
    public BookingDTO getBookingByID(@PathVariable(name = "bookingId") long bookingId) {
        return bookingService.getBookingByID(bookingId);
    }

    /*
    @GetMapping("/searchbybookingid")

    public List<List<Booking>> searchBookingsByID(
            @RequestParam(name = "bookingID") int booking_id) {

            return bookingService.searchBookingsByID(booking_id);
    }
     */


}

