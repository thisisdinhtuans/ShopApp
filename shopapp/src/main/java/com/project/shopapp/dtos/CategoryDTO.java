package com.project.shopapp.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data //toString
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class CategoryDTO {
    @NotEmpty(message = "Category's name cannot be empty")
    private String name;

    // Constructors
    public CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
