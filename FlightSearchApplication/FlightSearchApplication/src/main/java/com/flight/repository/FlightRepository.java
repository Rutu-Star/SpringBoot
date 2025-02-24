package com.flight.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	
	
	@Query("""
		       SELECT f FROM Flight f 
		       WHERE LOWER(f.source) LIKE LOWER(CONCAT('%', :source, '%'))
		         AND LOWER(f.destination) LIKE LOWER(CONCAT('%', :destination, '%'))
		         AND DATE(f.departureTime) = :departureTime
		         AND (:returnDate IS NULL OR DATE(f.returnDate) = :returnDate)
		         AND (f.total_seats - f.book_seats) >= :passengerCount
		       """)
	public List<Flight> getFlights(@RequestParam String source, @RequestParam String destination, @RequestParam  LocalDate  departureTime, @RequestParam LocalDate  returnDate, @RequestParam int passengerCount);

	

}