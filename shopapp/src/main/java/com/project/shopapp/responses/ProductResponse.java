package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.models.Product;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

//@AllArgsConstructor
//@Data
//@SuperBuilder
//@Getter
//@Setter
////@SuperBuilder
//@NoArgsConstructor
//public class ProductResponse extends BaseResponse {
//    private String name;
//    private Float price;
//    private String thumbnail;
//    private String description;
//
//    @JsonProperty("category_id")
//    private Long categoryId;
//
//
//    public static ProductResponse fromProduct(Product product) {
//        return ProductResponse.builder()  // Bây giờ sẽ trả về ProductResponseBuilder
//                .name(product.getName())
//                .price(product.getPrice())
//                .thumbnail(product.getThumbnail())
//                .description(product.getDescription())
//                .categoryId(product.getCategory().getId())
//                .createdAt(product.getCreatedAt())
//                .updatedAt(product.getUpdatedAt())
//                .build();
//    }

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse extends BaseResponse{
    private String name;
    private Float price;
    private String thumbnail;
    private String description;

    @JsonProperty("category_id")
    private Long categoryId;
    public static ProductResponse fromProduct(Product product) {
        ProductResponse productResponse = ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .thumbnail(product.getThumbnail())
                .description(product.getDescription())
                .categoryId(product.getCategory().getId())
                .build();
        productResponse.setCreatedAt(product.getCreatedAt());
        productResponse.setUpdatedAt(product.getUpdatedAt());
        return productResponse;
    }
}

//    public String getName() {
//        return name;
//    }
//
//    public Float getPrice() {
//        return price;
//    }
//
//    public String getThumbnail() {
//        return thumbnail;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//
//    private ProductResponse(Builder builder) {
//        this.name = builder.name;
//        this.price = builder.price;
//        this.thumbnail = builder.thumbnail;
//        this.description = builder.description;
//        this.categoryId = builder.categoryId;
//        setCreatedAt(builder.createdAt);
//        setUpdatedAt(builder.updatedAt);
//    }
//
//    // Static builder class
//    public static class Builder {
//        private String name;
//        private Float price;
//        private String thumbnail;
//        private String description;
//        private Long categoryId;
//        private LocalDate createdAt;
//        private LocalDate updatedAt;
//
//        public Builder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder price(Float price) {
//            this.price = price;
//            return this;
//        }
//
//        public Builder thumbnail(String thumbnail) {
//            this.thumbnail = thumbnail;
//            return this;
//        }
//
//        public Builder description(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public Builder categoryId(Long categoryId) {
//            this.categoryId = categoryId;
//            return this;
//        }
//
//        public Builder createdAt(LocalDate createdAt) {
//            this.createdAt = createdAt;
//            return this;
//        }
//
//        public Builder updatedAt(LocalDate updatedAt) {
//            this.updatedAt = updatedAt;
//            return this;
//        }
//
//        public ProductResponse build() {
//            return new ProductResponse(this);
//        }
//    }
//
//    public static Builder builder() {
//        return new Builder();
//    }
    // Add the builder method to return the Builder instance
//    public static BaseResponseBuilder builder() {
//        return new BaseResponseBuilder();
//    }
//}