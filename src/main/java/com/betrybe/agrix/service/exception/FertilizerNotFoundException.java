package com.betrybe.agrix.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * FertilizerNotFoundException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FertilizerNotFoundException extends NotFoundException {
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
