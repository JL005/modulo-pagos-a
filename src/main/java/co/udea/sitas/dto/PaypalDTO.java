package co.udea.sitas.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PaypalDTO {
    private String email;
    private String password;
}


