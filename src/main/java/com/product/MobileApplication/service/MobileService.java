package com.product.MobileApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.MobileApplication.model.Mobile;
import com.product.MobileApplication.repository.MobileRepo;

@Service
public class MobileService {
	@Autowired
	private MobileRepo mobilerepository;

	public Mobile updateMobileRecord(Mobile mob) {
		// TODO Auto-generated method stub
		return mobilerepository.save(mob);
	}
}
