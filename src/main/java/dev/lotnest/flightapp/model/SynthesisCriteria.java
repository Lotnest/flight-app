package dev.lotnest.flightapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SynthesisCriteria {

    private LocalDate departureDateMin;
    private LocalDate departureDateMax;
}
