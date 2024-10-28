package org.clevertech.servlet.pz.mapper;


import org.clevertech.servlet.pz.dto.CarDto;
import org.clevertech.servlet.pz.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto toCarDto(Car car);

    Car toCar(CarDto carDto);
}
