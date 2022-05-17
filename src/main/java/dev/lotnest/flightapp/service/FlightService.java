package dev.lotnest.flightapp.service;

import dev.lotnest.flightapp.dto.SyntheseCompanyDto;
import dev.lotnest.flightapp.model.Flight;
import dev.lotnest.flightapp.model.FlightCriteria;
import dev.lotnest.flightapp.model.SynthesisCriteria;

import java.util.List;

public interface FlightService {

    Flight addFlight(Flight flight);

    List<Flight> getFlights();

    List<Flight> searchFlights(FlightCriteria flightCriteria);

    Flight getFlight(Long flightId);

    Long getNumberFlights(SynthesisCriteria synthesisCriteria);

    List<SyntheseCompanyDto> getNumberFlightsByCompany(SynthesisCriteria synthesisCriteria);
}
