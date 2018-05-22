package com.rnc.dojolicense.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.rnc.dojolicense.models.License;
import com.rnc.dojolicense.repositories.LicenseRepo;
import com.rnc.dojolicense.models.License;

@Service
public class LicenseService {
	
	private LicenseRepo licenseRepo;
	
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	public License create(License license) {
		return licenseRepo.save(license);
	}
	
	public ArrayList<License> all() {
		return (ArrayList<License>) licenseRepo.findAll();
	}

	public License findById(Long id) {

		return licenseRepo.findOne(id);
	}
	
}
