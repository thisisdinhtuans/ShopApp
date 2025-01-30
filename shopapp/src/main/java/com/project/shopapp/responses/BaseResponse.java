package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseResponse {
    @JsonProperty("created_at")
    private LocalDateTime created_at;

    @JsonProperty("updated_at")
    private LocalDateTime updated_at;

    public void setCreatedAt(LocalDateTime createdAt) {
        this.created_at = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updated_at = updatedAt;
    }
}
