package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity(name = "City")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city.id")
    private Integer id;
    private String cityName;

    private Integer cityLatitude;
    private Integer cityLongtitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "country.id")
    private Country cityCountry;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name="maindata.id")
    private List<MainData> weatherData;
}
