package com.betrybe.agrix.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Farm not foun exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
