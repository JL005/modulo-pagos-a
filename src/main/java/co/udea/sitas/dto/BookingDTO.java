package co.udea.sitas.dto;


import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class BookingDTO {

    private long bookingId;
    private int passengerId;
    private int flightId;
    private String bookingDate;
    private double basePrice;
    private double tax;
    private double totalPrice;
    private boolean isPaid;
}
