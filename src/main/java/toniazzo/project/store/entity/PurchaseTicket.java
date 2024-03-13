package toniazzo.project.store.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "PurchaseTicket")
@Table(name = "purchaseTickets")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PurchaseTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Integer items;
}
