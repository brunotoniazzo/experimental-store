package toniazzo.project.store.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotNull(message = "Items cannot be empty")
    private Integer items;
}
