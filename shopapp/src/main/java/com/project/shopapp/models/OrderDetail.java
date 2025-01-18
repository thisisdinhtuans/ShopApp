package com.project.shopapp.models;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="order_details")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="number_of_products", nullable = false)
    private String numberOfProducts;

    @Column(name="total_money", nullable = false)
    private String totalMoney;

    @Column(name="color")
    private String color;
}
