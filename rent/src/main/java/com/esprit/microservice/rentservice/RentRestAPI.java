package com.esprit.microservice.rentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/rents")
public class RentRestAPI {
	@Autowired
	RentService rentService;
@Autowired
RentRepository rentRepository;
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Rent> createCandidat(@RequestBody Rent rent) {
//		return new ResponseEntity<>(rentService.addRent(rent), HttpStatus.OK);
//	}
	@GetMapping(value = "/getAllRents")
	@ResponseStatus(HttpStatus.OK)
public ResponseEntity<List<Rent>> getAllRents(){
		  List<Rent> rents = rentService.allRents();
	        if (rents.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(rents, HttpStatus.OK);
	        }
	    }
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Rent> updateRent(@PathVariable(value = "id") int id, @RequestBody Rent rent) {
		return new ResponseEntity<>(rentService.updateRent(id, rent), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteRent(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(rentService.deleteRent(id), HttpStatus.OK);
	}

	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rent> createEvaluation(@RequestBody Rent rent) {
		Rent evaluation = this.rentService.addRent(rent);
		return new ResponseEntity<>(evaluation, HttpStatus.CREATED);

	}
}
