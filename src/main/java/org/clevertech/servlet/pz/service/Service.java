package org.clevertech.servlet.pz.service;

import java.util.List;

public interface Service<T> {

    List<T> findByParams(String brand, String model, String description, Integer year,
                         String ownerPhone, Double minCost, Double maxCost);

    T save(T t);

    void delete(T t);
}
