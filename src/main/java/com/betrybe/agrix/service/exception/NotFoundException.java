package com.betrybe.agrix.service.exception;

/**
 * NotFoundException.
 */
public abstract class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
