package com.aivle12.book_backend.dto;

import com.aivle12.book_backend.domain.Preset;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PresetResponse {

    private Long id;
    private Long userId;
    private String name;
    private String prompt;
    private String style;
    private String background;
    private String lighting;
    private String typography;
    private String model;
    private String quality;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PresetResponse from(Preset preset) {
        return new PresetResponse(
                preset.getId(),
                preset.getUserId(),
                preset.getName(),
                preset.getPrompt(),
                preset.getStyle(),
                preset.getBackground(),
                preset.getLighting(),
                preset.getTypography(),
                preset.getModel(),
                preset.getQuality(),
                preset.getCreatedAt(),
                preset.getUpdatedAt()
        );
    }
}