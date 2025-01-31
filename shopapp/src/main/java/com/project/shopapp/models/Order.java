package com.project.shopapp.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

//import java.sql.Date;
//import java.time.LocalDateTime;
@Entity
@Table(name = "orders")
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
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "fullname", length = 100)
    private String fullName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number",nullable = false, length = 100)
    private String phoneNumber;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "note", length = 100)
    private String note;

    @Column(name="order_date")
    private Date orderDate;

    @Column(name = "status")
    private String status;

    @Column(name = "total_money")
    private Integer totalMoney;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "shipping_date")
    private LocalDate shippingDate;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "active")
    private Boolean active;//thuộc về admin

}


//@Entity
//@Table(name="orders")
//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;
//
//    @Column(name="fullname",length = 100)
//    private String fullName;
//
//    @Column(name="email",length = 100)
//    private String email;
//
//    @Column(name="phone_number",nullable = false,length = 100)
//    private String phoneNumber;
//
//    @Column(name="address",length = 100)
//    private String address;
//
//    @Column(name="note",length = 100)
//    private String note;
//
//    @Column(name="order_date",length = 100)
//    private Date orderDate;
//
//    @Column(name="status")
//    private String status;
//
//    @Column(name="total_money")
//    private Float totalMoney;
//
//    @Column(name="shipping_method")
//    private String shippingMethod;
//
//    @Column(name="shipping_address")
//    private String shippingAddress;
//
//    @Column(name="shipping_date")
//    private LocalDate shippingDate;
//
//    @Column(name="tracking_number")
//    private String trackingNumber;
//
//    @Column(name="payment_method")
//    private String paymentMethod;
//
//
//    @Column(name="active")
//    private Boolean active;
//
//    // Getter & Setter cho id
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    // Getter & Setter cho user
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    // Getter & Setter cho fullName
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    // Getter & Setter cho email
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    // Getter & Setter cho phoneNumber
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    // Getter & Setter cho address
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    // Getter & Setter cho note
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//
//    // Getter & Setter cho orderDate
//    public Date getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(Date orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    // Getter & Setter cho status
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    // Getter & Setter cho totalMoney
//    public Float getTotalMoney() {
//        return totalMoney;
//    }
//
//    public void setTotalMoney(Float totalMoney) {
//        this.totalMoney = totalMoney;
//    }
//
//    // Getter & Setter cho shippingMethod
//    public String getShippingMethod() {
//        return shippingMethod;
//    }
//
//    public void setShippingMethod(String shippingMethod) {
//        this.shippingMethod = shippingMethod;
//    }
//
//    // Getter & Setter cho shippingAddress
//    public String getShippingAddress() {
//        return shippingAddress;
//    }
//
//    public void setShippingAddress(String shippingAddress) {
//        this.shippingAddress = shippingAddress;
//    }
//
//    // Getter & Setter cho shippingDate
//    public LocalDate getShippingDate() {
//        return shippingDate;
//    }
//
//    public void setShippingDate(LocalDate shippingDate) {
//        this.shippingDate = shippingDate;
//    }
//
//    // Getter & Setter cho trackingNumber
//    public String getTrackingNumber() {
//        return trackingNumber;
//    }
//
//    public void setTrackingNumber(String trackingNumber) {
//        this.trackingNumber = trackingNumber;
//    }
//
//    // Getter & Setter cho paymentMethod
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//
//    // Getter & Setter cho active
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
//}
