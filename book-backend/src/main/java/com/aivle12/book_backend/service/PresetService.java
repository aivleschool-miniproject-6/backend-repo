package com.aivle12.book_backend.service;

import com.aivle12.book_backend.domain.Preset;
import com.aivle12.book_backend.dto.PresetCreateRequest;
import com.aivle12.book_backend.dto.PresetResponse;
import com.aivle12.book_backend.dto.PresetUpdateRequest;
import com.aivle12.book_backend.repository.PresetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PresetService {

    private final PresetRepository presetRepository;

    @Transactional(readOnly = true)
    public List<PresetResponse> getMyPresets(Long userId) {
        return presetRepository.findByUserIdOrderByCreatedAtDesc(userId)
                .stream()
                .map(PresetResponse::from)
                .toList();
    }

    public PresetResponse createPreset(PresetCreateRequest request, Long userId) {
        Preset preset = new Preset();
        preset.setUserId(userId);
        preset.setName(request.getName());
        preset.setPrompt(request.getPrompt());
        preset.setStyle(request.getStyle());
        preset.setBackground(request.getBackground());
        preset.setLighting(request.getLighting());
        preset.setTypography(request.getTypography());
        preset.setModel(request.getModel());
        preset.setQuality(request.getQuality());

        return PresetResponse.from(presetRepository.save(preset));
    }

    public PresetResponse updatePreset(Long id, PresetUpdateRequest request, Long userId) {
        Preset preset = presetRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Preset not found"));

        preset.setName(request.getName());
        preset.setPrompt(request.getPrompt());
        preset.setStyle(request.getStyle());
        preset.setBackground(request.getBackground());
        preset.setLighting(request.getLighting());
        preset.setTypography(request.getTypography());
        preset.setModel(request.getModel());
        preset.setQuality(request.getQuality());

        return PresetResponse.from(preset);
    }

    public void deletePreset(Long id, Long userId) {
        Preset preset = presetRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Preset not found"));

        presetRepository.delete(preset);
    }
}