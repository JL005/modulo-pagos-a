package co.udea.sitas.utils;

import java.util.stream.Collectors;
import java.util.List;

import co.udea.sitas.dto.PassengerDTO;
import co.udea.sitas.model.Passenger;

public class PassengerMapper {

    private PassengerMapper() {
    }

    public static PassengerDTO toDTO(Passenger passenger) {
        return PassengerDTO.builder()
                .name(passenger.getName())
                .seat(passenger.getSeat())
                .build();
    }

    public static List<PassengerDTO> toDTOList(List<Passenger> passengers) {
        return passengers.stream().map(PassengerMapper::toDTO).toList();
    }
}
