package dev.lotnest.flightapp.model;

import dev.lotnest.flightapp.enums.CompanyName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CompanyName name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @ToString.Exclude
    private Set<Flight> flights;

    @ElementCollection
    @CollectionTable(name = "cabin_details", joinColumns = @JoinColumn(name = "company_id"))
    private Set<CabinDetail> cabinDetails;

    @ElementCollection
    @CollectionTable(name = "inflight_infos", joinColumns = @JoinColumn(name = "company_id"))
    private Set<InflightInfo> inflightInfos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Company company = (Company) o;
        return id != null && Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
