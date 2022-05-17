package dev.lotnest.flightapp.model;

import dev.lotnest.flightapp.enums.FlightType;
import dev.lotnest.flightapp.enums.TravelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "flight_type")
    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @Column(name = "travel_type")
    @Enumerated(EnumType.STRING)
    private TravelType travelType;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "arrival_time")
    private LocalTime arrivalTime;

    @Column(name = "back_date")
    private LocalDate backDate;

    @Column(name = "back_time")
    private LocalTime backTime;

    @Column(name = "departure_location")
    private String departureLocation;

    @Column(name = "arrival_location")
    private String arrivalLocation;

    @Column(name = "flight_duration")
    private LocalTime flightDuration;

    @Column(name = "connection_duration")
    private LocalTime connectionDuration;

    @Column(name = "aircraft_type")
    private String aircraftType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(company, flight.company) && flightType == flight.flightType && travelType == flight.travelType && Objects.equals(departureDate, flight.departureDate) && Objects.equals(arrivalDate, flight.arrivalDate) && Objects.equals(backDate, flight.backDate) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(arrivalTime, flight.arrivalTime) && Objects.equals(backTime, flight.backTime) && Objects.equals(departureLocation, flight.departureLocation) && Objects.equals(arrivalLocation, flight.arrivalLocation) && Objects.equals(flightDuration, flight.flightDuration) && Objects.equals(connectionDuration, flight.connectionDuration) && Objects.equals(aircraftType, flight.aircraftType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, flightType, travelType, departureDate, arrivalDate, backDate, departureTime, arrivalTime, backTime, departureLocation, arrivalLocation, flightDuration, connectionDuration, aircraftType);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", company=" + company +
                ", flightType=" + flightType +
                ", travelType=" + travelType +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", backDate=" + backDate +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", backTime=" + backTime +
                ", departureLocation='" + departureLocation + '\'' +
                ", arrivalLocation='" + arrivalLocation + '\'' +
                ", flightDuration=" + flightDuration +
                ", connectionDuration=" + connectionDuration +
                ", aircraftType='" + aircraftType + '\'' +
                '}';
    }
}
