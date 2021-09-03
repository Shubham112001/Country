package com.plasmit.country.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plasmit.country.model.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {
	

}
