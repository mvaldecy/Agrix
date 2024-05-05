package com.betrybe.agrix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * CropFertilizer entity.
 */
@Entity
@Table(name = "crop_fertilizer")
public class CropFertilizer {
    
  @Column(name = "crop_id")
  private Long cropId;

  @Column(name = "fertilizer_id")
  private Long fertilizerId;

  public CropFertilizer() {}

  public CropFertilizer(Long cropId, Long fertilizerId) {
    this.cropId = cropId;
    this.fertilizerId = fertilizerId;
  }

  public Long getCropId() {
    return this.cropId;
  }

  public void setCropId(Long cropId) {
    this.cropId = cropId;
  }

  public Long getFertilizerId() {
    return this.fertilizerId;
  }

  public void setFertilizerId(Long fertilizerId) {
    this.fertilizerId = fertilizerId;
  }

}
