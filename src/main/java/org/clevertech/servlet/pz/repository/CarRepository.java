package org.clevertech.servlet.pz.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.clevertech.servlet.pz.entity.Car;
import org.clevertech.servlet.pz.util.CarGenerator;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarRepository implements Repository<Car> {

    private static final Repository<Car> INSTANCE = new CarRepository();
    private static List<Car> cars = CarGenerator.generateListRandomCars(20);

    public static Repository<Car> getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Car> findByParams(String brand, String model, String description, Integer year, String ownerPhone, Double minCost, Double maxCost) {
        return cars.stream()
                .filter(car ->
                        (null == brand || brand.equals(car.getBrand())) &&
                        (null == model || model.equals(car.getModel())) &&
                        (null == year || year.equals(car.getYear())) &&
                        (null == description || (null != car.getDescription() &&
                                car.getDescription().contains(description))) &&
                        (null == ownerPhone || ownerPhone.equals(car.getOwnerPhone())) &&
                        (null == minCost || (null != car.getCostInDollars() &&
                                minCost <= car.getCostInDollars())) &&
                        (null == maxCost || (null != car.getCostInDollars() &&
                                maxCost >= car.getCostInDollars()))
                )
                .toList();
    }

    @Override
    public Car save(Car car) {
        car.setUuid(UUID.randomUUID());
        cars.add(car);
        return car;
    }

    @Override
    public void delete(Car car) {
        if (null != car && null != car.getUuid()) {
            cars = cars.stream()
                    .filter(car1 -> !car1.getUuid().equals(car.getUuid()))
                    .collect(Collectors.toList());
        }
    }
}
