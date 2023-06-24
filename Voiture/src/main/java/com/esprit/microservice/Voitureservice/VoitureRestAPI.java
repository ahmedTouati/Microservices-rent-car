package com.esprit.microservice.Voitureservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/voitures")
public class VoitureRestAPI {
	private String title = "Hello, I'm the voiture Microservice";
	@Autowired
	private VoitureService voitureService;
	@RequestMapping("/welcome")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Voiture> createVoiture(@RequestBody Voiture Voiture) {
		return new ResponseEntity<>(voitureService.addVoiture(Voiture), HttpStatus.OK);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Voiture> updateVoiture(@PathVariable(value = "id") int id,
												 @RequestBody Voiture Voiture){
		return new ResponseEntity<>(voitureService.updateVoiture(id, Voiture), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteVoiture(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(voitureService.deleteVoiture(id), HttpStatus.OK);
	}
}
