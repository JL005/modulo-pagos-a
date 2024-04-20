package co.udea.sitas.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PassengerDTO {
    private String name;
    private String seat;    
}
