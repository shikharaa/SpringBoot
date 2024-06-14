package com.countryservice.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservice.demo.beans.country;
import com.countryservice.demo.controllers.AddResponse;
import com.countryservice.demo.repoistory.CountryRepository;


@Component
@Service
public class CountryService {
	
	//static HashMap<Integer,country> countryMap;
	
	/*
	 * public CountryService() {
	 * 
	 * countryMap = new HashMap<Integer,country>();
	 * 
	 * country e1 = new country(1,"India","Hyderbad"); country e2 = new
	 * country(1,"USA","DC"); country e3 = new country(1,"UK","London");
	 * 
	 * countryMap.put(1, e1); countryMap.put(2, e2); countryMap.put(3, e3);
	 * 
	 * 
	 * }
	 */
	
	@Autowired
	CountryRepository countryrep;
	
	public List getAllCountries() {
		
		/*
		 * List countries = new ArrayList(countryMap.values());
		 * 
		 * return countries;
		 */
		
		return countryrep.findAll();
		
	}
	
	public country getCountrybyID(int id) {
		
		//return countryMap.get(id);
		
		return countryrep.findById(id).get();
		
	}
	
	public country getCountrybyName(String name) {
		
		/*
		 * country c1 = null;
		 * 
		 * for(int i:countryMap.keySet()) {
		 * 
		 * if((countryMap.get(i).getCountryName()).equals(name)){ c1 =
		 * countryMap.get(i); } }
		 * 
		 * 
		 * return c1;
		 */
		
		List<country> countries = countryrep.findAll();
		country c1 = null;
		
		for(country con:countries) {
			if(con.getCountryName().equalsIgnoreCase(name)) {
				c1=con;
			}
		}
		
		return c1;
		
		
	}
	
	public country addCountry(country k1) {
		
		/*
		 * k1.setId(getMaxId()); countryMap.put(k1.getId(),k1);
		 * 
		 * return k1;
		 */
		
		k1.setId(getMaxId());
		countryrep.save(k1);
		
		return k1;
		
		
	}
	
	public  int getMaxId() {
		
		/*
		 * int max=0; for(int i : countryMap.keySet()) { if(max<=i) { max = i; } }
		 * return max+1;
		 */
		
		return countryrep.findAll().size()+1;
	}
	
	public country updateCountry(country country) {
		
		/*
		 * if(country.getId() >0) { countryMap.put(country.getId(), country); }
		 * 
		 * return country;
		 */
		
		countryrep.save(country);
		
		return country;
	}
	
	
	public AddResponse deleteCountry(int id) {
		
		/*
		 * countryMap.remove(id);
		 * 
		 * AddResponse res = new AddResponse("Coutry Delete", id); return res;
		 */
		
		countryrep.deleteById(id);
		AddResponse res = new AddResponse("Coutry Deleted", id);
		return res;
		
	}
	
	

}
