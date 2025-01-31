package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="categories")
@Data
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

//    // Constructor không tham số
//    public Category() {
//    }
//
//    // Constructor tất cả tham số
//    public Category(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    // Getters và Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    // Builder
//    public static class Builder {
//        private Long id;
//        private String name;
//
//        public Builder() {
//        }
//
//        public Builder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Category build() {
//            return new Category(id, name);
//        }
//    }
//
//    // Static method để tạo Builder
//    public static Builder builder() {
//        return new Builder();
//    }
}
