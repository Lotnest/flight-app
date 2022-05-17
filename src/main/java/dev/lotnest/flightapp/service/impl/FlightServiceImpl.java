package dev.lotnest.flightapp.service.impl;

import dev.lotnest.flightapp.dto.SyntheseCompanyDto;
import dev.lotnest.flightapp.model.Flight;
import dev.lotnest.flightapp.model.FlightCriteria;
import dev.lotnest.flightapp.model.SynthesisCriteria;
import dev.lotnest.flightapp.repository.FlightRepository;
import dev.lotnest.flightapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> searchFlights(FlightCriteria flightCriteria) {
        return flightRepository.searchFlights(flightCriteria);
    }

    @Override
    public Flight getFlight(Long flightId) {
        return flightRepository.findById(flightId).orElse(null);
    }

    @Override
    public Long getNumberFlights(SynthesisCriteria synthesisCriteria) {
        return flightRepository.getNumberFlights(synthesisCriteria);
    }

    @Override
    public List<SyntheseCompanyDto> getNumberFlightsByCompany(SynthesisCriteria synthesisCriteria) {
        return flightRepository.getNumberFlightsByCompany(synthesisCriteria);
    }
}
