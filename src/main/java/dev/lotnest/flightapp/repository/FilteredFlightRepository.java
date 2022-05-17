package dev.lotnest.flightapp.repository;

import dev.lotnest.flightapp.dto.SyntheseCompanyDto;
import dev.lotnest.flightapp.model.Flight;
import dev.lotnest.flightapp.model.FlightCriteria;
import dev.lotnest.flightapp.model.SynthesisCriteria;

import java.util.List;

public interface FilteredFlightRepository {

    List<Flight> searchFlights(FlightCriteria flightCriteria);

    Long getNumberFlights(SynthesisCriteria synthesisCriteria);

    List<SyntheseCompanyDto> getNumberFlightsByCompany(SynthesisCriteria synthesisCriteria);
}
