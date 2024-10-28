package org.clevertech.servlet.pz.entity;

import dev.morphia.annotations.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    private UUID uuid;
    private String brand;
    private String model;
    private Integer year;
    private String description;
    private String ownerPhone;
    private Double costInDollars;

}
