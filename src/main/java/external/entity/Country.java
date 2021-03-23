package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity(name = "Country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country.id")
    private Integer id;
    private String countryName;

 //   @ManyToOne(fetch = FetchType.LAZY)
//    @Cascade({org.hibernate.annotations.CascadeType.ALL})
//    @JoinColumn(name = "region.id")
 @ManyToOne
@JoinColumn(name = "id", nullable = false)
 private Region countryRegion;

//    @OneToMany(cascade={CascadeType.ALL})
//    @JoinColumn(name = "city.id")
//    private List<City> cities;

}
