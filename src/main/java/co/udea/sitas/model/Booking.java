package co.udea.sitas.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class  Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;
    @Column(name = "passenger_id")
    private int passengerId;
    @Column(name = "flight_id")
    private int flightId;
    @Column(name = "booking_date")
    private String bookingDate;
    @Column(name = "base_price")
    private double basePrice;
    @Column(name = "tax")
    private double tax;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "is_paid")
    private boolean isPaid;


}
