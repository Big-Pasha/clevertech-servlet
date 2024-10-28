package org.clevertech.servlet.pz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private UUID uuid;
    private String brand;
    private String model;
    private Integer year;
    private String description;
    private String ownerPhone;
    private Double costInDollars;

}
