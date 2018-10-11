package com.apap.tutorial5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDb flightDb;

	@Override
	public void addFlight(FlightModel flight) {
		flightDb.save(flight);
	}

	@Override
	public void deleteFlight(long id) {
		flightDb.deleteById(id);
	}

	@Override
	public FlightModel getFlightById(long id) {
		FlightModel flight = flightDb.findById(id);
		return flight;
	}

	@Override
	public FlightModel getFlightByFlightNumber(String flightNumber) {
		FlightModel flight = flightDb.findByFlightNumber(flightNumber);
		return flight;
	}
	
	

}
