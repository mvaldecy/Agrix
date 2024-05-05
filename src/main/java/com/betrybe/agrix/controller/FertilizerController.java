package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.FertilizerCreationDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.service.FertilizerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * FertilizerController.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizerController {
  FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  public ResponseEntity<FertilizerDto> createFertilizer(
      @RequestBody FertilizerCreationDto fertilizer) {
    return ResponseEntity.status(HttpStatus.CREATED)
    .body(this.fertilizerService.createFertilizer(fertilizer));
  }

  @GetMapping
  public ResponseEntity<List<FertilizerDto>> getAllFertilizers() {
    return ResponseEntity.status(HttpStatus.OK).body(this.fertilizerService.getAllFertilizers());
  }
}
