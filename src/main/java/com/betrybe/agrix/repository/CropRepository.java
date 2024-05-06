package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Crop Repository.
 */
public interface CropRepository extends JpaRepository<Crop, Integer> {
    
}
