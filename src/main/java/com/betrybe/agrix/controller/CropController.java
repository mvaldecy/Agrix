package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Crop Controller.
 */
@RequestMapping(value = "/crops")
@RestController
public class CropController {
  private final FarmService farmService;

  @Autowired
  public CropController(FarmService farmService) {
    this.farmService = farmService;
  }

  @GetMapping
  public ResponseEntity<List<CropDto>> getAllCrops() {
    return ResponseEntity.status(HttpStatus.OK).body(farmService.getAllCrops());
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.OK).body(farmService.getCropById(id));
  }

  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> getCropByDate(
      @RequestParam(value = "start") String startDate,
      @RequestParam(value = "end") String endDate
  ) {
    return ResponseEntity.status(HttpStatus.OK).body(farmService.getCropByDate(startDate, endDate));
  }

  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateCropIdFertilizerid(
      @PathVariable Integer cropId,
      @PathVariable Integer fertilizerId
  ) {
    return ResponseEntity.status(HttpStatus.CREATED)
      .body(farmService.associateCropFertilizer(cropId, fertilizerId));
  }

  @GetMapping("/{id}/fertilizers")
  public ResponseEntity<List<FertilizerDto>> getCropFertilizers(
      @PathVariable Integer id
  ) {
    return ResponseEntity.status(HttpStatus.OK)
      .body(this.farmService.getCropFertilizers(id));
  }

}
