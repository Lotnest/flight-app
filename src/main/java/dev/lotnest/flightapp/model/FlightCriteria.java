package dev.lotnest.flightapp.model;

import dev.lotnest.flightapp.enums.CompanyName;
import dev.lotnest.flightapp.enums.FlightType;
import dev.lotnest.flightapp.enums.TravelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightCriteria {

    private CompanyName companyName;
    private FlightType flightType;
    private TravelType travelType;
    private String departureLocation;
    private String arrivalLocation;
    private Double fareMin;
    private Double fareMax;
    private LocalTime flightDurationMin;
    private LocalTime flightDurationMax;
    private String aircraftType;
    private LocalDate departureDateMin;
    private LocalDate arrivalDateMin;
    private LocalDate backDateMin;
    private LocalTime departureTimeMin;
    private LocalTime arrivalTimeMin;
    private LocalTime backTimeMin;
    private LocalDate departureDateMax;
    private LocalDate arrivalDateMax;
    private LocalDate backDateMax;
    private LocalTime departureTimeMax;
    private LocalTime arrivalTimeMax;
    private LocalTime backTimeMax;
    private LocalTime connectionDurationMin;
    private LocalTime connectionDurationMax;
}
