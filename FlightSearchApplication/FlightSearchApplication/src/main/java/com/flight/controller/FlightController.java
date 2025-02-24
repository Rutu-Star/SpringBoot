package com.flight.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.model.Flight;
import com.flight.service.FlightServices;

@RestController
@RequestMapping("/api/flights/search")
public class FlightController {
	
	@Autowired
	FlightServices flightService;
	
	//get flight details in( from , to , departureDate ,return date , passengercount)
	
	@GetMapping("/flight-search")
	public List<Flight> getFlights(
			@RequestParam String source, 
			@RequestParam String destination, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  departureTime, 
			@RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  returnDate, 
			@RequestParam int passengerCount)
	{
			
		return flightService.getFlights(source, destination, departureTime, returnDate, passengerCount);
	}
	
	@GetMapping("/filters_sorts")
	public List<Flight> searchFlightFilteringSorting(
			@RequestParam String source, 
			@RequestParam String destination, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  departureTime, 
			@RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  returnDate, 
			@RequestParam int passengerCount,
			@RequestParam(required=false) Double priceMin,
			@RequestParam(required=false) Double priceMax,
			@RequestParam(required=false) String airline,
			@RequestParam(required=false) String sortBy,
			@PageableDefault(page = 0, size = 5) Pageable pageable,
			@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer size
			)
	{
		
		  if (page != null && size != null) {
	            pageable = PageRequest.of(page, size);
	        }
	        
		
		List<Flight> allFlights=flightService.getFlights(source, destination, departureTime, returnDate, passengerCount);
		Page<Flight> pageFlights=flightService.searchFlightFilteringSorting(allFlights, priceMin, priceMax, airline, sortBy,pageable);
		return pageFlights.getContent();
	}
	
	
	
	


}
