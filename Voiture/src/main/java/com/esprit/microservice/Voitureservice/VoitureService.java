package com.esprit.microservice.Voitureservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {

	@Autowired
	private VoitureRepository voitureRepository;

	public Voiture addVoiture(Voiture voiture) {
		return voitureRepository.save(voiture);
	}
	public Voiture updateVoiture(int id, Voiture newVoiture) {
		if (voitureRepository.findById(id).isPresent()) {
			Voiture existingVoiture = voitureRepository.findById(id).get();
			existingVoiture.setType(newVoiture.getType());
			existingVoiture.setPrice(newVoiture.getPrice());
			existingVoiture.setMarque(newVoiture.getMarque());

			return voitureRepository.save(existingVoiture);
		} else
			return null;
	}
	public String deleteVoiture(int id) {
		if (voitureRepository.findById(id).isPresent()) {
			voitureRepository.deleteById(id);
			return "Voiture supprimé";
		} else
			return "Voiture non supprimé";
	}
}
