package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "Region")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String regionName;

//    @OneToMany(mappedBy = "countryRegion", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "countryRegion", cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
  //  @JoinColumn(name="country.id")
    private List<Country> countries;// = new ArrayList<>();

}
