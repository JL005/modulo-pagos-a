package co.udea.sitas.dto;


import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaypalDTO {
    private String email;
    private String password;
    private long bookingId;
}


