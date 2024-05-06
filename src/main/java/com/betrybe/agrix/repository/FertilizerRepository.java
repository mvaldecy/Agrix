package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * FertilizerRepository.
 */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Integer> {
    
}
