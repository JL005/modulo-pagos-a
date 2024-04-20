package co.udea.sitas.dto;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PaymentMethodDTO {

    private long id;
    private String name;

}
