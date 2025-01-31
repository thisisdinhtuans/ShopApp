package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@MappedSuperclass
//public class BaseEntity {
//    @Column(name = "created_at", updatable = false)
//    private LocalDate createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDate updatedAt;
//
//    // Getter cho createdAt
//    public LocalDate getCreatedAt() {
//        return createdAt;
//    }
//
//    // Setter cho createdAt
//    public void setCreatedAt(LocalDate createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    // Getter cho updatedAt
//    public LocalDate getUpdatedAt() {
//        return updatedAt;
//    }
//
//    // Setter cho updatedAt
//    public void setUpdatedAt(LocalDate updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    // Tự động gán giá trị khi entity được tạo mới
//    @PrePersist
//    protected void onCreate() {
//        createdAt = LocalDate.now();
//        updatedAt = LocalDate.now();
//    }
//
//    // Tự động cập nhật thời gian khi entity thay đổi
//    @PreUpdate
//    protected void onUpdate() {
//        updatedAt = LocalDate.now();
//    }
//}
@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public class BaseEntity{
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
