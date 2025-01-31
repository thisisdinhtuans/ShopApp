package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_images")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImage {
    public static final int MAXIMUM_IMAGES_PER_PRODUCT=5;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="image_url", length = 300)
    private String imageUrl;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//    // Thêm Builder thủ công
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//        private Long id;
//        private Product product;
//        private String imageUrl;
//
//        public Builder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder product(Product product) {
//            this.product = product;
//            return this;
//        }
//
//        public Builder imageUrl(String imageUrl) {
//            this.imageUrl = imageUrl;
//            return this;
//        }
//
//        public ProductImage build() {
//            ProductImage productImage = new ProductImage();
//            productImage.setId(this.id);
//            productImage.setProduct(this.product);
//            productImage.setImageUrl(this.imageUrl);
//            return productImage;
//        }
//
//    }
}
