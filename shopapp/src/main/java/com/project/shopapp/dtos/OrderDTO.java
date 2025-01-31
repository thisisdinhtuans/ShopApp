package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

    @JsonProperty("user_id")
    @Min(value = 1, message = "User's ID must be > 0")
    private Long userId;

    @JsonProperty("fullname")
    private String fullName;

    private String email;

    @JsonProperty("phone_number")
    @NotBlank(message = "Phone number is required")
    @Size(min = 5, message = "Phone number must be at least 5 characters")
    private String phoneNumber;

    private String address;

    private String note;

    @JsonProperty("total_money")
    @Min(value = 0, message = "Total money must be >= 0")
    private Float totalMoney;

    @JsonProperty("shipping_method")
    private String shippingMethod;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("shipping_date")
    private LocalDate shippingDate;

    @JsonProperty("payment_method")
    private String paymentMethod;


}

//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class OrderDTO {
//
//    @JsonProperty("user_id")
//    @Min(value =1, message="User's ID must be >0")
//    private Long userId;
//
//    @JsonProperty("fullname")
//    private String fullName;
//
//    private String email;
//
//    @JsonProperty("phone_number")
//    @NotBlank(message = "Phone number is required")
//    @Size(min=5, message = "Phone number must be at least 5 characters")
//    private String phoneNumber;
//
//    private String address;
//
//    private String note;
//
//    @JsonProperty("total_money")
//    @Min(value=0, message = "Total money must be >= 0")
//    private Float totalMoney;
//
//    @JsonProperty("shipping_method")
//    private String shippingMethod;
//
//    @JsonProperty("shipping_address")
//    private String shippingAddress;
//
//    @JsonProperty("payment_method")
//    private String paymentMethod;
//
//    @JsonProperty("shipping_date")
//    private LocalDate shippingDate;
//
//    // Getter & Setter cho userId
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
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
//    // Getter & Setter cho paymentMethod
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
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
//}
