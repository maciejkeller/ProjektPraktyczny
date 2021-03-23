package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


import javax.persistence.*;
import java.util.List;

@Entity(name = "Country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "country_name", nullable = false, table = "Country")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "country_region")
    //name = "country_region" to kolumna z tabeli country mająca klucz obcy
    private Region countryRegion;

    @OneToMany(mappedBy = "id")
    private List<City> cities;
}

