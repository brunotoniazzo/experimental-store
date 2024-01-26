package toniazzo.project.store.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PurchaseTicket {

    @Id
    @SequenceGenerator(
            name = "purchaseTicket_sequence",
            sequenceName = "purchaseTicket_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "purchaseTicket_sequence")
    private Long id;


    private String description;


    private Integer items;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Product product;


}
