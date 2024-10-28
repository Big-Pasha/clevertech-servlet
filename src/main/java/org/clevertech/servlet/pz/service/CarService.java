package org.clevertech.servlet.pz.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.clevertech.servlet.pz.dto.CarDto;
import org.clevertech.servlet.pz.entity.Car;
import org.clevertech.servlet.pz.mapper.CarMapper;
import org.clevertech.servlet.pz.repository.CarRepository;
import org.clevertech.servlet.pz.repository.Repository;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarService implements Service<CarDto> {

    private static final Service<CarDto> INSTANCE = new CarService();
    private final Repository<Car> carRepository = CarRepository.getInstance();

    public static Service<CarDto> getInstance() {
        return INSTANCE;
    }

    @Override
    public List<CarDto> findByParams(String brand, String model, String description, Integer year, String ownerPhone, Double minCost, Double maxCost) {
        return carRepository.findByParams(brand, model, description, year, ownerPhone, minCost, maxCost).stream()
                .map(CarMapper.INSTANCE::toCarDto)
                .toList();
    }

    @Override
    public CarDto save(CarDto carDto) {
        Car car = carRepository.save(CarMapper.INSTANCE.toCar(carDto));
        return CarMapper.INSTANCE.toCarDto(car);
    }

    @Override
    public void delete(CarDto carDto) {
        carRepository.delete(CarMapper.INSTANCE.toCar(carDto));
    }
}
