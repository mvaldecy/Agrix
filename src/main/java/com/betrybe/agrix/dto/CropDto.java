package com.betrybe.agrix.dto;

/**
 * CropDto.
 */
public record CropDto(Long id, String name, Double plantedArea, Long farmId) {}
