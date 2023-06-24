package com.esprit.microservice.rentservice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class RentService {
	@Autowired
	private RentRepository rentRepository;

	public Rent addRent(Rent rent) {
		return rentRepository.save(rent);
	}
	public Rent updateRent(int id, Rent newRent ) {
		if (rentRepository.findById(id).isPresent()) {
			Rent oldRent = rentRepository.findById(id).get();
			oldRent.setCustomerId(newRent.getCustomerId());
			oldRent.setNbrOfDays(newRent.getNbrOfDays());
			return rentRepository.save(oldRent);
		} else
			return null;
	}
//	public Page<Rent> listRents(int ownerId) {
//		Pageable firstPageWithManyElements = PageRequest.of(0, 15);
//	return rentRepository.rentByownerId(ownerId, firstPageWithManyElements);
//	}
	
	public String deleteRent(int id) {
		if (rentRepository.findById(id).isPresent()) {
			rentRepository.deleteById(id);
			return "rent deleted";
		} else
			return "rent does not even exist dumbAss !";
	}
	public List<Rent> allRents(){
		return rentRepository.findAll();
	}
	}
