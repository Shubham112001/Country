package com.plasmit.country.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plasmit.country.model.Country;
import com.plasmit.country.repo.CountryRepo;

@Service
public class countryService {
	@Autowired
	CountryRepo crepo;
	public void insert(Country country) {
		try{
			crepo.save(country);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public List getCountry() {
		List list= crepo.findAll();
		return list;
	}
	public Optional<Country> getOne(int id) {
		return crepo.findById(id);
	}
	public void delete(int id) {
		crepo.deleteById(id);
	}
	public Country edit(Country country) 
	{		
		return crepo.save(country);
	}
	public Boolean isExist(int id) {
		return crepo.existsById(id);
		 
	}

}
