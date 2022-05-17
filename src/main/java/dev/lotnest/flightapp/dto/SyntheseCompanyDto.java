package dev.lotnest.flightapp.dto;

import dev.lotnest.flightapp.enums.CompanyName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyntheseCompanyDto {

    private CompanyName companyName;
    private Long numberFlights;
}
