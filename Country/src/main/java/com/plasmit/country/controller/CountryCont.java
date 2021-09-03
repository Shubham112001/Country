package com.plasmit.country.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plasmit.country.model.Country;
import com.plasmit.country.repo.CountryRepo;
import com.plasmit.country.service.countryService;

@RestController
public class CountryCont {
	@Autowired
	countryService cser;
	@PostMapping("/countrySave")
	public ResponseEntity<String> insert(@RequestBody Country country) {	
		if(cser.isExist(country.getcId())) {
			return new ResponseEntity<String>("Exist",HttpStatus.CONFLICT);
		}
		else {
			cser.insert(country);
			return new ResponseEntity<String>("Created",HttpStatus.CREATED);
		
		}
		}

	
	@GetMapping("/getAllCountry")
	public ResponseEntity<List<Country>> getCountry(){
		List<Country> a=cser.getCountry();
		if(a.isEmpty() || a==null){
			return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Country>>(a,HttpStatus.OK);
		}
		
	}

	
	@GetMapping("/getCountryById/{cId}")
	public ResponseEntity<Optional<Country>> getCountry(@PathVariable("cId")int id){
		Optional<Country> c=cser.getOne(id);
		if(c==null || c.isEmpty()) {
			return new ResponseEntity<Optional<Country>>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Optional<Country>>(c,HttpStatus.FOUND);
		}
	}
	@DeleteMapping("/reomoveCountry/{cId}")
	public ResponseEntity<String> removeCountry(@PathVariable("cId")int id){
		if(!cser.isExist(id)) {
			return new ResponseEntity<String>("Not Exist",HttpStatus.NOT_FOUND);
		}
		else {
			cser.delete(id);
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
	}
	@PutMapping("/country")
	public ResponseEntity<String> update(@RequestBody Country country) {
		if(!cser.isExist(country.getcId())) {
			return new ResponseEntity<String>("Not Exist",HttpStatus.NOT_FOUND);
		}
		else {
			cser.edit(country);
			return new ResponseEntity<String>("Updated",HttpStatus.OK);
		}
		
	}
	


}
