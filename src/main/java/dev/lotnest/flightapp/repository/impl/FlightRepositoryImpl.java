package dev.lotnest.flightapp.repository.impl;

import dev.lotnest.flightapp.dto.SyntheseCompanyDto;
import dev.lotnest.flightapp.enums.CompanyName;
import dev.lotnest.flightapp.model.Flight;
import dev.lotnest.flightapp.model.FlightCriteria;
import dev.lotnest.flightapp.model.SynthesisCriteria;
import dev.lotnest.flightapp.repository.FilteredFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FlightRepositoryImpl implements FilteredFlightRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Flight> searchFlights(FlightCriteria flightCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
        Root<Flight> flight = criteriaQuery.from(Flight.class);
        List<Predicate> predicates = new ArrayList<>();

        if (flightCriteria.getCompanyName() != null) {
            predicates.add(criteriaBuilder.equal(flight.get("company").get("name"), flightCriteria.getCompanyName()));
        }

        if (flightCriteria.getFlightType() != null) {
            predicates.add(criteriaBuilder.equal(flight.get("flightType"), flightCriteria.getFlightType().toString().toUpperCase(Locale.ROOT)));
        }

        if (flightCriteria.getTravelType() != null) {
            predicates.add(criteriaBuilder.equal(flight.get("travelType"), flightCriteria.getTravelType().toString().toUpperCase(Locale.ROOT)));
        }

        if (flightCriteria.getDepartureLocation() != null) {
            predicates.add(criteriaBuilder.like(flight.get("departureLocation"), "%" + flightCriteria.getDepartureLocation() + "%"));
        }

        if (flightCriteria.getArrivalLocation() != null) {
            predicates.add(criteriaBuilder.like(flight.get("arrivalLocation"), "%" + flightCriteria.getArrivalLocation() + "%"));
        }

        if (flightCriteria.getAircraftType() != null) {
            predicates.add(criteriaBuilder.like(flight.get("aircraftType"), "%" + flightCriteria.getAircraftType() + "%"));
        }

        if (flightCriteria.getDepartureDateMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("departureDateMin"), flightCriteria.getDepartureDateMin()));
        }

        if (flightCriteria.getDepartureDateMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("departureDateMax"), flightCriteria.getDepartureDateMax()));
        }

        if (flightCriteria.getDepartureTimeMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("departureTimeMin"), flightCriteria.getDepartureTimeMin()));
        }

        if (flightCriteria.getDepartureTimeMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("departureTimeMax"), flightCriteria.getDepartureTimeMax()));
        }

        if (flightCriteria.getArrivalDateMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("arrivalDateMin"), flightCriteria.getArrivalDateMin()));
        }

        if (flightCriteria.getDepartureDateMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("departureDateMax"), flightCriteria.getDepartureDateMax()));
        }

        if (flightCriteria.getArrivalTimeMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("arrivalTimeMin"), flightCriteria.getArrivalTimeMin()));
        }

        if (flightCriteria.getArrivalDateMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("arrivalDateMin"), flightCriteria.getArrivalDateMax()));
        }

        if (flightCriteria.getBackDateMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("backDateMin"), flightCriteria.getBackDateMin()));
        }

        if (flightCriteria.getArrivalTimeMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("arrivalTimeMax"), flightCriteria.getArrivalTimeMax()));
        }

        if (flightCriteria.getBackTimeMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("backTimeMin"), flightCriteria.getBackTimeMin()));
        }

        if (flightCriteria.getBackDateMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("backDateMax"), flightCriteria.getBackDateMax()));
        }

        if (flightCriteria.getConnectionDurationMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("connectionDurationMin"), flightCriteria.getConnectionDurationMin()));
        }

        if (flightCriteria.getBackTimeMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("backTimeMax"), flightCriteria.getBackTimeMax()));
        }

        if (flightCriteria.getFlightDurationMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("flightDurationMin"), flightCriteria.getFlightDurationMin()));
        }

        if (flightCriteria.getConnectionDurationMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("connectionDurationMax"), flightCriteria.getConnectionDurationMax()));
        }

        if (flightCriteria.getFlightDurationMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("flightDurationMin"), flightCriteria.getFlightDurationMin()));
        }

        if (flightCriteria.getFlightDurationMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("flightDurationMax"), flightCriteria.getFlightDurationMax()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Long getNumberFlights(SynthesisCriteria synthesisCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Flight> flight = criteriaQuery.from(Flight.class);
        List<Predicate> predicates = new ArrayList<>();

        criteriaQuery.select(criteriaBuilder.count(flight));

        predicateSynthesisCriteria(synthesisCriteria, criteriaBuilder, criteriaQuery, flight, predicates);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<SyntheseCompanyDto> getNumberFlightsByCompany(SynthesisCriteria synthesisCriteria) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SyntheseCompanyDto> criteriaQuery = criteriaBuilder.createQuery(SyntheseCompanyDto.class);
        Root<Flight> flight = criteriaQuery.from(Flight.class);
        List<Predicate> predicates = new ArrayList<>();

        Expression<CompanyName> groupByExpression = flight.get("company").get("name").as(CompanyName.class);
        Expression<Long> countExpression = criteriaBuilder.count(groupByExpression);

        criteriaQuery.multiselect(groupByExpression, countExpression);
        criteriaQuery.groupBy(groupByExpression);

        predicateSynthesisCriteria(synthesisCriteria, criteriaBuilder, criteriaQuery, flight, predicates);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    private void predicateSynthesisCriteria(SynthesisCriteria synthesisCriteria, CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<Flight> flight, List<Predicate> predicates) {
        if (synthesisCriteria.getDepartureDateMin() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(flight.get("departureDateMin"), synthesisCriteria.getDepartureDateMin()));
        }

        if (synthesisCriteria.getDepartureDateMax() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(flight.get("departureDateMax"), synthesisCriteria.getDepartureDateMax()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
    }
}
