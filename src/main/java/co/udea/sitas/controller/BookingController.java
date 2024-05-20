package co.udea.sitas.controller;

import co.udea.sitas.dto.BookingDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import co.udea.sitas.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Reservas de vuelos", description = "API que permite consultar las reservas disponibles en el sistema")
@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;
    @Operation(summary = "Obtener los datos de una reserva", description = "Se obtienen los datos de una reserva entregando su ID")
    @GetMapping("/{bookingId}")
    public BookingDTO getBookingByID(@PathVariable(name = "bookingId") long bookingId) {
        return bookingService.getBookingByID(bookingId);
    }

    @Operation(summary = "Obtener todas las reservas que no han sido pagadas", description = "Se obtiene un listado de todas las reservas que no han sido pagadas")
    @GetMapping("/")
    public List<BookingDTO> getUnpaidBookings() {
        return bookingService.getUnpaidBookings();
    }
}

