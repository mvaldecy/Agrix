package com.betrybe.agrix.dto;

import java.time.LocalDate;

/**
 * CropDto.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDat,
    Long farmId) {}
