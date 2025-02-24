package com.flight.model;

import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="airline", nullable=false)
	private String airline;
	@Column(name="source ", nullable=false)
	private String source ;
	@Column(name="destination", nullable=false)
	private String destination;
	@Column(name="departureTime", nullable=false)
	private LocalDateTime   departureTime;
	@Column(name="arrivalTime", nullable=false)
	private LocalDateTime   arrivalTime;
	private LocalDateTime  returnDate ;
	
	@Column(name="price", nullable=false)
	private double price;
	
	@Column(name="duration", nullable=false)
	private String duration;
	
	@Column(name="total_seats", nullable=false)
	private int total_seats;
	


	private int  stops;
	private int book_seats;
	
	public int getBook_seats() {
		return book_seats;
	}

	public void setBook_seats(int book_seats) {
		this.book_seats = book_seats;
	}

	public int getTotal_seats() {
		return total_seats;
	}

	public void setTotal_seats(int total_seats) {
		this.total_seats = total_seats;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public LocalDateTime  getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime  departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime  getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime  arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime  getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime  returnDate) {
		this.returnDate = returnDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", source=" + source + ", destination=" + destination
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", returnDate=" + returnDate
				+ ", price=" + price + ", duration=" + duration + ", book_seats=" + book_seats + ", total_seats="
				+ total_seats + ", stops=" + stops + "]";
	}

	


	


}
