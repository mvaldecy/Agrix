package com.betrybe.agrix.dto;

import java.time.LocalDate;

/**
 * CropDto.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    Long farmId,
    LocalDate plantedDate,
    LocalDate harvestDate) {}
