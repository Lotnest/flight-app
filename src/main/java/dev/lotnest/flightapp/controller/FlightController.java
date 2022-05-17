package dev.lotnest.flightapp.controller;

import dev.lotnest.flightapp.dto.AccountDto;
import dev.lotnest.flightapp.dto.FlightDto;
import dev.lotnest.flightapp.dto.SyntheseCompanyDto;
import dev.lotnest.flightapp.model.Account;
import dev.lotnest.flightapp.model.Flight;
import dev.lotnest.flightapp.model.FlightCriteria;
import dev.lotnest.flightapp.model.SynthesisCriteria;
import dev.lotnest.flightapp.service.AccountService;
import dev.lotnest.flightapp.service.FlightService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("flight-webservices/api/v1.0/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    AccountService accountService;

    private final ModelMapper modelMapper;

    PropertyMap<Flight, FlightDto> companyFieldMapping = new PropertyMap<>() {
        @Override
        protected void configure() {
            map().setName(source.getCompany().getName());
            map().setCabinDetails(source.getCompany().getCabinDetails());
            map().setInflightInfos(source.getCompany().getInflightInfos());
        }
    };

    public FlightController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(companyFieldMapping);
    }

    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight result = flightService.addFlight(flight);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/list")
    public ResponseEntity<List<FlightDto>> getFlights() {
        List<FlightDto> result = flightService.getFlights().stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/search")
    public ResponseEntity<List<FlightDto>> searchFlights(@RequestBody FlightCriteria flightCriteria) {
        List<FlightDto> result = flightService.searchFlights(flightCriteria).stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FlightDto> getFlight(@PathVariable(value = "id") Long flightId) {
        Flight flight = flightService.getFlight(flightId);
        FlightDto result = modelMapper.map(flight, FlightDto.class);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/number")
    public ResponseEntity<Long> getNumberFlights(@RequestBody SynthesisCriteria synthesisCriteria) {
        Long result = flightService.getNumberFlights(synthesisCriteria);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/syntheseCompany")
    public ResponseEntity<List<SyntheseCompanyDto>> getNumberFlightsByCompany(@RequestBody SynthesisCriteria synthesisCriteria) {
        List<SyntheseCompanyDto> result = flightService.getNumberFlightsByCompany(synthesisCriteria);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<Account> addAccount(@RequestBody AccountDto accountDto) {
        Account result = accountService.addAccount(accountDto);
        return ResponseEntity.ok(result);
    }
}
