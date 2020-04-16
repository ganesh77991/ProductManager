package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.jpa.CountryJpa;
import com.product.jpa.StateJpa;
import com.product.model.Country;
import com.product.model.State;

@Repository
public class AddressDao {
	
	@Autowired
	CountryJpa countryJpa;
	
	@Autowired
	StateJpa stateJpa;
	
	public List<Country> getCountries(){
		
		return countryJpa.findAll();
	}


	public List<State> getStatesByCountryId(Integer countryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
