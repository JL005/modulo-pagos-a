package co.udea.sitas.controller;

import co.udea.sitas.service.PassengerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import co.udea.sitas.dto.PassengerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Pasajeros de vuelo", description = "API que permite consultar los pasajeros de un vuelo")
@RestController
@RequestMapping("/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @Operation(summary = "Obtener los pasajeros", description = "Se obtiene un listado de todos los pasajeros de un vuelo")
    @GetMapping("/")
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        try {
            return new ResponseEntity<>(this.passengerService.getAllPassengers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
