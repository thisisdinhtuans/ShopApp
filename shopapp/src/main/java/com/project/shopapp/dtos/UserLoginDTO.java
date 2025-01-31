package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data //toString
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty("phone_number")
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Password cannot be blank")
    private String password;
//    // Constructors
//    public UserLoginDTO() {
//    }
//
//    public UserLoginDTO(String phoneNumber, String password) {
//        this.phoneNumber = phoneNumber;
//        this.password = password;
//    }

//    // Getters and Setters
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
