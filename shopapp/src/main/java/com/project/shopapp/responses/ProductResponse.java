package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.models.Product;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductResponse extends BaseResponse {
    private String name;
    private Float price;
    private String thumbnail;
    private String description;

    @JsonProperty("category_id")
    private Long categoryId;

    public static ProductResponse fromProduct(Product product) {
        ProductResponse productResponse=ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .thumbnail(product.getThumbnail())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
        return productResponse;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }


    private ProductResponse(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.thumbnail = builder.thumbnail;
        this.description = builder.description;
        this.categoryId = builder.categoryId;
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    // Static builder class
    public static class Builder {
        private String name;
        private Float price;
        private String thumbnail;
        private String description;
        private Long categoryId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(Float price) {
            this.price = price;
            return this;
        }

        public Builder thumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ProductResponse build() {
            return new ProductResponse(this);
        }
    }

    // Add the builder method to return the Builder instance
    public static Builder builder() {
        return new Builder();
    }
}