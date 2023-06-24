package com.esprit.microservice.rentservice;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer>{
//	@Query("select f from Rent f where f.customerId = :customerId")
//	public Page<Rent> rentByownerId(@Param("customerId") Integer o, Pageable pageable);
}
