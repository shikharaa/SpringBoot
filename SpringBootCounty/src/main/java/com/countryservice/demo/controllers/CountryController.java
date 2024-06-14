package com.countryservice.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.demo.beans.country;
import com.countryservice.demo.services.CountryService;

@RestController
@RequestMapping("")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getcountries")
	public List getCountries() {
		
		return countryService.getAllCountries();
		
		
	}
	
	@GetMapping("/getcountries/{id}")
	public ResponseEntity<country> getCountriesId(@PathVariable(value="id") int id) {
		
		
		try {
			country country = countryService.getCountrybyID(id);
			return new ResponseEntity<country>(country, HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@GetMapping("/getcountries/countryname")
	public ResponseEntity<country> getCountriesByName(@RequestParam(value = "name") String name) {
		
		//return countryService.getCountrybyName(name);
		
		try {
			country country = countryService.getCountrybyName(name);
			return new ResponseEntity<country>(country, HttpStatus.OK);
		}catch(Exception e) {
			System.out.println("Not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@PostMapping("/addcountry")
	public country postCountry(@RequestBody country country) {
		
		return countryService.addCountry(country);
		
	}
	
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<country> putCountry(@PathVariable(value = "id") int id, @RequestBody country country) {
		
		//return countryService.updateCountry(country);
		try {
		country existCountry = countryService.getCountrybyID(id);
		existCountry.setCountryName(country.getCountryName());
		existCountry.setCountryCaptial(country.getCountryCaptial());
		
		country updated_country = countryService.updateCountry(existCountry);
		return new ResponseEntity<country>(updated_country, HttpStatus.OK);
		
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		
	}
	
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id) {
		
		return countryService.deleteCountry(id);
		
	}
	


}
