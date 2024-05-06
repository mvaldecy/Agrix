package com.betrybe.agrix.dto;

import java.time.LocalDate;

/**
 * CropDto.
 */
public record CropDto(
    Integer id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    Long farmId) {}
