package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getter cho createdAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setter cho createdAt
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getter cho updatedAt
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setter cho updatedAt
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Tự động gán giá trị khi entity được tạo mới
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    // Tự động cập nhật thời gian khi entity thay đổi
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}