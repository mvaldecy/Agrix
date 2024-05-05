package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.CropFertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Crop_fertilizer repository.
 */
public interface CropFertilizerRepository extends JpaRepository<CropFertilizer, Long> {
    
}
