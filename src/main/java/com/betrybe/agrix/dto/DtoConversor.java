package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Crop;
import java.util.List;


/**
 * DtoConversor.
 */
public abstract class DtoConversor {
  /**
   * CropModlToDto.
   */
  public static List<CropDto> cropModelToDto(List<Crop> cropList) {
    return cropList.stream()
          .map((crop) -> new CropDto(
            crop.getId(),
            crop.getName(),
            crop.getPlantedArea(),
            crop.getFarm().getId(),
            crop.getPlantedDate(),
            crop.getHarvestDate()
            )).toList();
  }
}
