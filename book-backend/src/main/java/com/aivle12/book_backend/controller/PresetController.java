package com.aivle12.book_backend.controller;

import com.aivle12.book_backend.dto.PresetCreateRequest;
import com.aivle12.book_backend.dto.PresetResponse;
import com.aivle12.book_backend.dto.PresetUpdateRequest;
import com.aivle12.book_backend.service.PresetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presets")
@RequiredArgsConstructor
public class PresetController {

    private final PresetService presetService;

    @GetMapping
    public ResponseEntity<List<PresetResponse>> getMyPresets(
            @AuthenticationPrincipal Long userId
    ) {
        return ResponseEntity.ok(presetService.getMyPresets(userId));
    }

    @PostMapping
    public ResponseEntity<PresetResponse> createPreset(
            @Valid @RequestBody PresetCreateRequest request,
            @AuthenticationPrincipal Long userId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(presetService.createPreset(request, userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PresetResponse> updatePreset(
            @PathVariable Long id,
            @Valid @RequestBody PresetUpdateRequest request,
            @AuthenticationPrincipal Long userId
    ) {
        return ResponseEntity.ok(presetService.updatePreset(id, request, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreset(
            @PathVariable Long id,
            @AuthenticationPrincipal Long userId
    ) {
        presetService.deletePreset(id, userId);
        return ResponseEntity.noContent().build();
    }
}