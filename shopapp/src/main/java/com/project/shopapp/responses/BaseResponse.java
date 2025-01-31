package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@AllArgsConstructor
//@Data
//@SuperBuilder
////@SuperBuilder
//@NoArgsConstructor
//public class BaseResponse {
//    @JsonProperty("created_at")
//    private LocalDate createdAt;
//
//    @JsonProperty("updated_at")
//    private LocalDate updatedAt;
//
//    public void setCreatedAt(LocalDate createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setUpdatedAt(LocalDate updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//}
@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseResponse {
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
