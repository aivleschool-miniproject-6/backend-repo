package com.aivle12.book_backend.repository;

import com.aivle12.book_backend.domain.Preset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PresetRepository extends JpaRepository<Preset, Long> {

    List<Preset> findByUserIdOrderByCreatedAtDesc(Long userId);

    Optional<Preset> findByIdAndUserId(Long id, Long userId);

    boolean existsByUserIdAndName(Long userId, String name);
}