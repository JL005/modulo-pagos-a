package co.udea.sitas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "seat")
    private String seat;
}
