package co.udea.sitas.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardPaidDTO {

    private String cardNumber;
    private String name;
    private double amount;
    private String cardType;

}