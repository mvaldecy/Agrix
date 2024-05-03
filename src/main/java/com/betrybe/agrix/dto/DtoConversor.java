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
}
