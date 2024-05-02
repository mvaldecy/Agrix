package com.betrybe.agrix.controller;


import com.betrybe.agrix.dto.CropCreationDto;
import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FarmCreationDto;
import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farm controller.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {
  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  public ResponseEntity<FarmDto> createFarm(@RequestBody FarmCreationDto farm) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(farmService.create(farm));
  }

  /**
   * Getall farms.
   */
  @GetMapping
  public ResponseEntity<List<FarmDto>> getAll() {
    List<FarmDto> allFarms = farmService.getAll()
        .stream().map(farm -> new FarmDto(farm.getId(), farm.getName(), farm.getSize()))
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(allFarms);
  }

  /**
   * getFarmById.
   */
  @GetMapping("/{id}")
  public ResponseEntity<FarmDto> getFarmById(@PathVariable Long id) {
    FarmDto farm = farmService.getFarmById(id);
    return ResponseEntity.status(HttpStatus.OK).body(farm);
  }

  /**
   * postCrop.
   */
  @PostMapping("/{id}/crops")
  public ResponseEntity<CropDto> createCrop(
      @PathVariable Long id,
      @RequestBody CropCreationDto crop) {
    return ResponseEntity.status(HttpStatus.CREATED).body(farmService.createCrop(crop, id));
  }

  /**
   * getCropByFarmId controller.
   */
  @GetMapping("/{id}/crops")
  public ResponseEntity<List<CropDto>> getCropByFarmId(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(farmService.getCropByFarmId(id));
  }
}
