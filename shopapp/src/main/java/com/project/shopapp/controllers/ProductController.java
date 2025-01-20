package com.project.shopapp.controllers;

import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.exceptions.InvalidParamException;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.services.IProductService;
import com.project.shopapp.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/products")
//@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("") //http://localhost:8088/api/v1/categories?page=1&limit=10
    public ResponseEntity<String> getProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        return ResponseEntity.ok("getProducts");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId) {
        return ResponseEntity.ok("Product with id " + productId);
    }

    @PostMapping("")
    public ResponseEntity<?> insertProduct(

            @Valid @RequestBody ProductDTO productDTO,
//            @ModelAttribute("files") List<MultipartFile> files,
//            @RequestPart("file") MultipartFile file,
            BindingResult result) throws IOException, DataNotFoundException, InvalidParamException {
        if(result.hasErrors()) {
            List<String> errorMessages=result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        Product newProduct=productService.createProduct(productDTO);


        return ResponseEntity.ok(newProduct);
    }

    @PostMapping(value="uploads/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImages(
            @PathVariable("id") Long productId,
            @RequestParam("files") List<MultipartFile> files) {
        try {
            // Kiểm tra xem sản phẩm có tồn tại không
            Product existingProduct = productService.getProductById(productId);
            files = (files == null) ? new ArrayList<>() : files;
            if(files.size()>ProductImage.MAXIMUM_IMAGES_PER_PRODUCT) {
                return ResponseEntity.badRequest().body("You can only upload maximum 5 images");
            }
            List<ProductImage> productImages = new ArrayList<>();

            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    continue;
                }
                // Kiểm tra kích thước và định dạng file
                if (file.getSize() > 10 * 1024 * 1024) {
                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File is too large! Maximum size is 10MB");
                }
                String contentType = file.getContentType();
                if (contentType == null || !contentType.startsWith("image/")) {
                    return ResponseEntity.badRequest().body("File must be an image");
                }

                // Lưu file và cập nhật ProductImage
                String fileName = storeFile(file);
//                if (fileName == null) {
//                    return ResponseEntity.badRequest().body("Failed to store file");
//                }

                ProductImage productImage = productService.createProductImage(existingProduct.getId(),
                        ProductImageDTO.builder().imageUrl(fileName).build());
                productImages.add(productImage);
            }

            return ResponseEntity.ok(productImages);
        } catch (DataNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IOException e) {
            // Lỗi trong quá trình lưu file
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload error: " + e.getMessage());
        } catch (Exception e) {
            // Ghi log lỗi chi tiết
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    private boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType !=null && contentType.startsWith("image/");
    }

    //Hàm nữa để lưu file này lại
    private String storeFile(MultipartFile file) throws IOException {
        if(!isImageFile(file) || file.getOriginalFilename()==null) {
            throw new IOException("Invalid image file");
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //Thêm UUID vào trước tên file để đảm bảo tên file là duy nhất
        String uniqueFileName = UUID.randomUUID().toString()+"_"+fileName;
        //Đường dẫn đến thuw mục mà bạn muốn luwu file
        java.nio.file.Path uploadDir= Paths.get("upload");
        //Kiểm tra và tạo thư muc neeus nó ko tồn tại
        if(!Files.exists(uploadDir)) {
            Files.createDirectory(uploadDir);
        }
        //Đường dẫn đầy đủ đến file
        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFileName);
        //Sao chép file vào thư mục đích
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@RequestParam long id) {
        return ResponseEntity.ok("Product deleted sucessfully");
    }
}
