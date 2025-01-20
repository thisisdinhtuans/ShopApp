package com.project.shopapp.services;

import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.exceptions.InvalidParamException;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.Category;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.repositories.CategoryRepository;
import com.project.shopapp.repositories.ProductImageRepository;
import com.project.shopapp.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductImageRepository productImageRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productImageRepository = productImageRepository;
    }
    @Override
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException {
        Category existingCategory=categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new DataNotFoundException("Cannot find category with id: "+productDTO.getCategoryId()));
        Product newProduct = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .thumbnail(productDTO.getThumbnail())
                .category(existingCategory)
                .build();
        return productRepository.save(newProduct);
    }

    @Override
    public Product getProductById(long productId) throws DataNotFoundException {
        return productRepository.findById(productId).orElseThrow(()->new DataNotFoundException("Cannot find product with id ="+productId));
    }

    @Override
    public Page<Product> getAllProducts(PageRequest pageRequest) {
        //lấy danh sách sản phẩm theo trang(page) và giới hạn(limit)

        return productRepository.findAll(pageRequest);
    }

    @Override
    public Product updateProduct(long id, ProductDTO productDTO) throws Exception {
        Product existingProduct=getProductById(id);
        if(existingProduct!=null) {
            Category existingCategory=categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new DataNotFoundException("Cannot find category with id: "+productDTO.getCategoryId()));
            existingProduct.setName(productDTO.getName());
            existingProduct.setCategory(existingCategory);
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setThumbnail(productDTO.getThumbnail());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> optionalProduct=productRepository.findById(id);
        optionalProduct.ifPresent(productRepository::delete);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws DataNotFoundException, InvalidParamException {
        Product existingpProduct=productRepository.findById(productImageDTO.getProductId()).orElseThrow(()->new DataNotFoundException("Cannot find product with id:" +productImageDTO.getProductId()));
        ProductImage newProductImage=new ProductImage().builder()
                .product(existingpProduct)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        //ko cho insert qúa 5 ảnh cho 1 sản phẩm
        int size=productImageRepository.findByProductId(productId).size();
        if(size>=5) {
            throw new InvalidParamException("Number of images must be <=5");
        }
        return productImageRepository.save(newProductImage);
    }
}
