package com.project.shopapp.responses;

import com.project.shopapp.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

//@AllArgsConstructor
//@Data
////@Builder
//@NoArgsConstructor
//public class ProductListResponse {
//    private List<ProductResponse> products;
//    private int totalPages;
//
//    // Constructor riêng cho Builder
//    private ProductListResponse(Builder builder) {
//        this.products = builder.products;
//        this.totalPages = builder.totalPages;
//    }
//
//    // Getters
//    public List<ProductResponse> getProducts() {
//        return products;
//    }
//
//    public int getTotalPages() {
//        return totalPages;
//    }
//
//    // Setters
//    public void setProducts(List<ProductResponse> products) {
//        this.products = products;
//    }
//
//    public void setTotalPages(int totalPages) {
//        this.totalPages = totalPages;
//    }
//
//    // Static Builder Class
//    public static class Builder {
//        private List<ProductResponse> products;
//        private int totalPages;
//
//        public Builder products(List<ProductResponse> products) {
//            this.products = products;
//            return this;
//        }
//
//        public Builder totalPages(int totalPages) {
//            this.totalPages = totalPages;
//            return this;
//        }
//
//        public ProductListResponse build() {
//            return new ProductListResponse(this);
//        }
//    }
//
//    // Method to get the Builder instance
//    public static Builder builder() {
//        return new Builder();
//    }
//}
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ProductListResponse {
    private List<ProductResponse> products;
    private int totalPages;
}
