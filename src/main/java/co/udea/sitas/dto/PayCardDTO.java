package co.udea.sitas.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayCardDTO {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private int cvv;
    private String phone;
    private int idNumber;
    private long bookingId;
}
