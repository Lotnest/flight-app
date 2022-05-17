package dev.lotnest.flightapp.repository;

import dev.lotnest.flightapp.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, FilteredFlightRepository {
}
