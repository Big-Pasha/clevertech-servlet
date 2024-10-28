package org.clevertech.servlet.pz.util;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.clevertech.servlet.pz.entity.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarGenerator {

    private static Map<String, List<String>> carBrandModel;
    private static List<String> descriptions;

    private static Random random = new Random();

    private static final int minYear = 2005;
    private static final int maxYear = 2024;

    private static final double minPrice = 1200;
    private static final double maxPrice = 22000;

    static {
        carBrandModel = new HashMap<>();
        carBrandModel.put("BMW", Arrays.asList("M3", "M5", "M7"));
        carBrandModel.put("AUDI", Arrays.asList("A4", "A6", "A7"));
        carBrandModel.put("LADA", Arrays.asList("Granta", "Vesta", "2114"));

        descriptions = new ArrayList<>();
        descriptions.add("not beaten, not painted");
        descriptions.add("call after 5:00");
        descriptions.add("perfect condition");
        descriptions.add("bargaining");
    }

    public static List<Car> generateListRandomCars(Integer listSize) {
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            cars.add(generateRandomCar());
        }

        return cars;
    }

    public static Car generateRandomCar(){
        Car car = new Car();
        car.setUuid(UUID.randomUUID());
        car.setBrand(getRandomBrand());
        car.setModel(getRandomValueFromList(carBrandModel.get(car.getBrand())));
        car.setDescription(getRandomValueFromList(descriptions));
        car.setYear(getRandomYear());
        car.setCostInDollars(getRandomPrice());

        return car;
    }

    private static Double getRandomPrice() {
        return Math.floor(
                (minPrice + (random.nextDouble() * (maxPrice - minPrice))) * 100
        ) / 100;
    }

    private static Integer getRandomYear() {
        return minYear + random.nextInt(maxYear - minYear);
    }

    private static String getRandomBrand() {
        int randomBrand = random.nextInt(carBrandModel.size());
        return new ArrayList<>(carBrandModel.keySet()).get(randomBrand);
    }

    private static String getRandomValueFromList(List<String> valueList) {
        return valueList.get(random.nextInt(valueList.size()));
    }

}
