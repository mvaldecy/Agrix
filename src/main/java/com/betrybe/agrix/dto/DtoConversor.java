package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Fertilizer;

import java.util.List;


/**
 * DtoConversor.
 */
public abstract class DtoConversor {
  /**
   * CropModlToDto.
   */
  public static CropDto cropModelToDto(Crop crop) {
    return new CropDto(
            crop.getId(),
            crop.getName(),
            crop.getPlantedArea(),
            crop.getPlantedDate(),
            crop.getHarvestDate(),
            crop.getFarm().getId()
            );
  }

  public static Fertilizer fertilizerCropToModel(FertilizerCreationDto fertilizerDto) {
    return new Fertilizer(fertilizerDto.name(), fertilizerDto.brand(), fertilizerDto.composition());
  }

  /**
   * fertilizerModelToDto.
   */
  public static FertilizerDto fertilizerModelToCrop(Fertilizer fertilizer) {
    return new FertilizerDto(
            fertilizer.getId(),
            fertilizer.getName(),
            fertilizer.getBrand(),
            fertilizer.getComposition()
    );
  }
}
