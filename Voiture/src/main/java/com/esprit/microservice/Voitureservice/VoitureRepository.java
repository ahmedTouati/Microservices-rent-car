package com.esprit.microservice.Voitureservice;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoitureRepository extends JpaRepository<Voiture, Integer> {
	@Query("select c from Voiture c where c.type like :type")
	public Page<Voiture> voitureByType(@Param("type") String n, Pageable pageable);
	   
}
