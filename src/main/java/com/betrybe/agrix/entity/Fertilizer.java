package com.betrybe.agrix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Fertilizer entity.
 */
@Entity
@Table(name = "fertilizer")
public class Fertilizer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String brand;
  private String composition;

  @ManyToMany
  @JoinTable(
      name = "crop_fertilizer",
      joinColumns = @JoinColumn(name = "fertilizer_id"),
      inverseJoinColumns = @JoinColumn(name = "crop_id"))
  private List<Crop> crops;

  public Fertilizer() {}

  /**
   * Fertilizer constructor.
   */
  public Fertilizer(String name, String brand, String composition) {
    this.name = name;
    this.brand = brand;
    this.composition = composition;
  }

    
}
