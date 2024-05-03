package com.betrybe.agrix.dto;

import java.time.LocalDate;

/**
 * CropCreatioDto.
 */
public record CropCreationDto(
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate) {}
