package co.udea.sitas.Controller;

import co.udea.sitas.Model.Booking;
import co.udea.sitas.Model.PaymentMethod.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.udea.sitas.Service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @GetMapping("/searchbybookingid")
    public List<List<Booking>> searchBookingsByID(
            @RequestParam(name = "bookingID") int booking_id) {

            return bookingService.searchBookingsByID(booking_id);
    }

}

