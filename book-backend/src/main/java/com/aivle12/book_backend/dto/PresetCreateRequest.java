package com.aivle12.book_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PresetCreateRequest {

    @NotBlank
    private String name;

    private String prompt;

    private String style;

    private String background;

    private String lighting;

    private String typography;

    private String model;

    private String quality;
}