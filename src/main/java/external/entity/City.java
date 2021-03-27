package external.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "City")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, table = "City")
    private Integer id;

    @Column(name = "name", nullable = false, table = "City")
    private String cityName;

    @Column(name = "latitude", table = "City")
    private Integer cityLatitude;

    @Column(name = "longtitude", nullable = false, table = "City")
    private Integer cityLongtitude;


    @ManyToOne
    @JoinColumn(name = "country", nullable = false)
    private Country cityCountry;

    @OneToMany(mappedBy = "id")
    private List<WeatherData> weatherData;
}
