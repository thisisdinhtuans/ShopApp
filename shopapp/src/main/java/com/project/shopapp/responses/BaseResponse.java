package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder  // Dùng SuperBuilder thay vì Builder
public class BaseResponse {
    @JsonProperty("created_at")
    private LocalDateTime created_at;

    @JsonProperty("updated_at")
    private LocalDateTime updated_at;
}