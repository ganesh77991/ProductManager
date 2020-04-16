package com.product.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.model.State;

public interface StateJpa extends JpaRepository<State, Integer> {
	

}
