package dev.lotnest.flightapp.dto;

import dev.lotnest.flightapp.enums.CompanyName;
import dev.lotnest.flightapp.enums.FlightType;
import dev.lotnest.flightapp.enums.TravelType;
import dev.lotnest.flightapp.model.CabinDetail;
import dev.lotnest.flightapp.model.InflightInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDto {

    private Long id;
    private CompanyName name;
    private FlightType flightType;
    private TravelType travelType;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private LocalDate backDate;
    private LocalTime backTime;
    private String departureLocation;
    private String arrivalLocation;
    private LocalTime flightDuration;
    private LocalTime connectionDuration;
    private String aircraftType;
    private Set<CabinDetail> cabinDetails;
    private Set<String> comforts;
    private Set<InflightInfo> inflightInfos;
}
