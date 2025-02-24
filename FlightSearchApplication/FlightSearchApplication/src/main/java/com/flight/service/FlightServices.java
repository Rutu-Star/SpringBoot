package com.flight.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;


import com.flight.model.Flight;
import com.flight.repository.FlightRepository;

@Service
public class FlightServices {
	
	@Autowired
	FlightRepository flightRepository;
	
	//get flight details in( from , to , departureDate ,return date , passengercount)
	public List<Flight> getFlights(String source, String destination, LocalDate  departureTime, LocalDate  returnDate, int passengerCount)
	{
		
		return flightRepository.getFlights(source, destination, departureTime, returnDate, passengerCount);
	}
	
	
	//get flight base on filtering and sorting 
	public Page<Flight> searchFlightFilteringSorting(List<Flight> allFlights , Double priceMin, Double priceMax, String airline, String sortBy, Pageable pageable)
	{
		//set default values for price range if not provided
		double minPrice = (priceMin !=null) ? priceMin : allFlights.stream()
		        .mapToDouble(Flight::getPrice)
		        .min()
		        .orElse(100.00);	
		double maxPrice = (priceMax!=null) ? priceMax : allFlights.stream()
		        .mapToDouble(Flight::getPrice)
		        .max()
		        .orElse(1000.00);
		
		//apply filters here 
		allFlights = allFlights.stream()
                .filter(f -> f.getPrice() >= minPrice && f.getPrice() <= maxPrice) // Price Filter
                .filter(f -> airline == null || airline.contains("any") || airline.equalsIgnoreCase(f.getAirline())) // Airlines Filter
                .collect(Collectors.toList());
		
		//now sorting apply
		Comparator<Flight> comparator;
		
		switch((sortBy != null) ? sortBy.toLowerCase() : "price")
		{
		
		case "duration":
		    comparator = Comparator.comparing(f -> getDurationInMinutes(f.getDuration())); 
			break;
		case "airline":
			comparator=Comparator.comparing(Flight::getAirline);
			break;
		default:
			comparator=Comparator.comparing(Flight::getPrice);
		}
		
		allFlights.sort(comparator);
		        

        // Apply pagination only for this method
        List<Flight> pagedFlights = allFlights.stream()
                .skip(pageable.getOffset())
                .limit(pageable.getPageSize())
                .collect(Collectors.toList());

        return new PageImpl<>(pagedFlights, pageable, allFlights.size());
	}
	

	
	
	
	
	public int getDurationInMinutes(String duration) {
	    String durationStr = duration.toLowerCase().replaceAll(" ", ""); // Remove all spaces
	    int hours = 0, minutes = 0;

	    if (durationStr.contains("h")) {
	        String[] parts = durationStr.split("h");
	        hours = Integer.parseInt(parts[0]);  // Hours extracted before "h"
	        if (parts.length > 1 && parts[1].contains("m")) {
	            minutes = Integer.parseInt(parts[1].replace("m", ""));  // Extract minutes after "h"
	        }
	    } else if (durationStr.contains("m")) {
	        minutes = Integer.parseInt(durationStr.replace("m", ""));
	    }
	    return hours * 60 + minutes;
	}


	


}
