package co.udea.sitas.service;

import co.udea.sitas.repository.PassengerRepository;
import co.udea.sitas.utils.PassengerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import co.udea.sitas.dto.PassengerDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public List<PassengerDTO> getAllPassengers() {
        return PassengerMapper.toDTOList(passengerRepository.findAll());
    }
}
