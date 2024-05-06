package com.betrybe.agrix.service;

import com.betrybe.agrix.dto.DtoConversor;
import com.betrybe.agrix.dto.FertilizerCreationDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.repository.FertilizerRepository;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * FertilierService.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * createFertilizer.
   */
  public FertilizerDto createFertilizer(FertilizerCreationDto fertilizer) {
    Fertilizer newFertilizer = this.fertilizerRepository.save(
        DtoConversor.fertilizerCropToModel(fertilizer)
    );
    return DtoConversor.fertilizerModelToCrop(newFertilizer);
  }

  /**
   * getFertilizers.
   */
  public List<FertilizerDto> getAllFertilizers() {
    List<Fertilizer> fertilizersList = this.fertilizerRepository.findAll();
    List<FertilizerDto> fertilizersDto = fertilizersList.stream()
        .map((fertilizer) -> DtoConversor.fertilizerModelToCrop(fertilizer)).toList();
    return fertilizersDto;
  }

  /**
   * GetFertilizerById.
   */
  public FertilizerDto getFertilizerById(Integer id) {
    Fertilizer fertilizer = this.fertilizerRepository.findById(id)
            .orElseThrow(FertilizerNotFoundException::new);
    return DtoConversor.fertilizerModelToCrop(fertilizer);
  }
}
