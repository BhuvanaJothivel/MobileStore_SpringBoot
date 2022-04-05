package com.product.MobileApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.MobileApplication.model.Mobile;
import com.product.MobileApplication.repository.MobileRepo;
import com.product.MobileApplication.service.MobileService;

@RestController
public class MobileController {
	
	@Autowired
	private MobileRepo mobilerepository;
	
	@Autowired 
	private MobileService ms;
	
	@PostMapping("/addmobile")
	public Mobile addMobile(@RequestBody Mobile mob) {
		return mobilerepository.save(mob);
	}
	
	@GetMapping("/getAllMobile")
	public List<Mobile> fetchAllMobile() {
		return mobilerepository.findAll();
	}
	
	@GetMapping("/getMobile/{id}")
	public Optional<Mobile> fetchMobileById(@PathVariable int id) {
		return mobilerepository.findById(id);
	}
	
	@DeleteMapping("/deleteMobile/{id}")
	public String deleteMobileById(@PathVariable int id) {
		String result;
		try {
			mobilerepository.deleteById(id);
			result = "mobile product deleted successfully";
		}
		catch(Exception e) {
			result = "mobile product not deleted";
		}
		
		return result;
		
	}
	
	@DeleteMapping("/deleteAllMobile")
	public String deleteAllMobile() {
		String result;
		try {
			mobilerepository.deleteAll();
			result = "all mobile products deleted successfully";
		}
		catch(Exception e) {
			result = "error occurred";
		}
		
		return result;
		
	}

	@PutMapping("/updateMobile")
	public Mobile updateMobile(@RequestBody Mobile mob) {
		return ms.updateMobileRecord(mob);
	}
	
	
}
