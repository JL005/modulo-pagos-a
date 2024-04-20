package co.udea.sitas.mapper;

import co.udea.sitas.dto.PassengerDTO;
import co.udea.sitas.model.Passenger;
import co.udea.sitas.utils.PassengerMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class PassengerMapperTest {

    @Test
    public void testToDTO() {
        // Arrange
        Passenger passenger = Passenger.builder().name("John Doe")
                .seat("A1").build();

        // Act
        PassengerDTO passengerDTO = PassengerMapper.toDTO(passenger);

        // Assert
        assertEquals(passenger.getName(), passengerDTO.getName());
        assertEquals(passenger.getSeat(), passengerDTO.getSeat());
    }

    @Test
    public void testToDTOList() {
        // Arrange
        List<Passenger> passengers = Arrays.asList(
                Passenger.builder().name("John Doe").seat("A1").build(),
                Passenger.builder().name("Jane Smith").seat("B2").build()
                );

        // Act
        List<PassengerDTO> passengerDTOList = PassengerMapper.toDTOList(passengers);

        // Assert
        assertEquals(passengers.size(), passengerDTOList.size());
        assertEquals(passengers.get(0).getName(), passengerDTOList.get(0).getName());
        assertEquals(passengers.get(0).getSeat(), passengerDTOList.get(0).getSeat());
        assertEquals(passengers.get(1).getName(), passengerDTOList.get(1).getName());
        assertEquals(passengers.get(1).getSeat(), passengerDTOList.get(1).getSeat());
    }
}