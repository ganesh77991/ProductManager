package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.City;

public interface CityJpa extends JpaRepository<City, Integer> {

}
