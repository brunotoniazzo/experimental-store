package toniazzo.project.store.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "Product")
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @NotNull(message = "Price cannot be empty")
    @Positive
    private BigDecimal price;

    @NotNull(message = "Quantity cannot be empty")
    @PositiveOrZero(message = "Quantity must be more than 0")
    private Integer quantity;

    @NotNull(message = "Category ID cannot be empty")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
