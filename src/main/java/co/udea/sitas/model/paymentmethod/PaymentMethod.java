package co.udea.sitas.model.paymentmethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "payment_method")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentMethod {

    @Id
    @Column(name = "payment_method_id")
    private long id;
    @Column(name = "payment_method_name")
    private String name;

}
