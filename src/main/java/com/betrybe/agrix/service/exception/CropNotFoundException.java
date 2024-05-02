package com.betrybe.agrix.service.exception;

/**
 * CropNotFoundException.
 */
public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
