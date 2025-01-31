package com.project.shopapp.models;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="fullname",length = 100)
    private String fullName;

    @Column(name="email",length = 100)
    private String email;

    @Column(name="phone_number",nullable = false,length = 100)
    private String phoneNumber;

    @Column(name="address",length = 100)
    private String address;

    @Column(name="note",length = 100)
    private String note;

    @Column(name="order_date",length = 100)
    private LocalDate orderDate;

    @Column(name="status")
    private String status;

    @Column(name="total_money")
    private String totalMoney;

    @Column(name="shipping_method")
    private String shippingMethod;

    @Column(name="shipping_address")
    private String shippingAddress;

    @Column(name="shipping_date")
    private LocalDate shippingDate;

    @Column(name="tracking_number")
    private String trackingNumber;

    @Column(name="payment_method")
    private String paymentMethod;


    @Column(name="active")
    private Boolean active;

}
