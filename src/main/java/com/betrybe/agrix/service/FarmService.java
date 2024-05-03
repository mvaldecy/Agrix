package com.betrybe.agrix.service;

import com.betrybe.agrix.dto.CropCreationDto;
import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.DtoConversor;
import com.betrybe.agrix.dto.FarmCreationDto;
import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.repository.FarmRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FarmService. 
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * PostFarm.
   */
  public FarmDto create(FarmCreationDto farm) {
    Farm newFarm = new Farm(farm.name(), farm.size());
    Farm farmCreated = farmRepository.save(newFarm);
    return new FarmDto(
        farmCreated.getId(),
        farmCreated.getName(),
        farmCreated.getSize()
    );
  }
  
  /**
   * Getall farms.
   */
  public List<Farm> getAll() {
    return farmRepository.findAll();
  }

  /**
   * getFarms by id.
   */
  public FarmDto getFarmById(Long id) {
    Farm farm = farmRepository.findById(id)
            .orElseThrow(FarmNotFoundException::new);
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }

  /**
   * PostCrop.
   */
  public CropDto createCrop(CropCreationDto cropBody, Long farmId) {
    FarmDto farmDto = this.getFarmById(farmId);
    Farm farm = new Farm(farmDto.name(), farmDto.size());
    farm.setId(farmDto.id());
    Crop newCrop = new Crop();
    newCrop.setName(cropBody.name());
    newCrop.setPlantedArea(cropBody.plantedArea());
    newCrop.setPlantedDate(cropBody.plantedDate());
    newCrop.setHarvestDate(cropBody.harvestDate());
    newCrop.setFarm(farm);

    Crop createdCrop = cropRepository.save(newCrop);
    CropDto cropResponse = new CropDto(createdCrop.getId(),
        createdCrop.getName(),
        createdCrop.getPlantedArea(),
        createdCrop.getPlantedDate(),
        createdCrop.getHarvestDate(),
        farmId
    );
    return cropResponse;
  }

  /**
   * GetCropByFarmId service.
   */
  public List<CropDto> getCropByFarmId(Long id) {
    this.getFarmById(id);
    List<Crop> crops = cropRepository.findAll()
          .stream().filter((crop) -> crop.getFarm().getId() == id).toList();
    List<CropDto> cropDtoList = crops.stream()
        .map((crop) -> DtoConversor.cropModelToDto(crop)).toList();
    return cropDtoList;
  }

  /**
   * getAllCrops.
   */
  public List<CropDto> getAllCrops() {
    List<Crop> crops = cropRepository.findAll();
    List<CropDto> cropDtoList = crops.stream()
        .map((crop) -> DtoConversor.cropModelToDto(crop)).toList();
    return cropDtoList;
  }

  /**
   * getCropById.
   */
  public CropDto getCropById(Long id) {
    Crop crop = cropRepository.findById(id)
        .orElseThrow(CropNotFoundException::new);
    CropDto cropResponse = new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getPlantedDate(),
        crop.getHarvestDate(),
        crop.getFarm().getId()
    );
    return cropResponse;
  }
}