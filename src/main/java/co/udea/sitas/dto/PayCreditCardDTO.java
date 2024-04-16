package co.udea.sitas.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayCreditCardDTO extends PayCardDTO{

    private int installments;

}
