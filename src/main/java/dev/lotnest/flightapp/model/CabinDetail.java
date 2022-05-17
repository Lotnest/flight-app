package dev.lotnest.flightapp.model;

import dev.lotnest.flightapp.enums.CabinClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabinDetail {

    @Enumerated(EnumType.STRING)
    private CabinClass cabinClass;
    private String baggage;
    private String cancellation;
    private String rebooking;
    private String refund;
    private Double fare;
}
