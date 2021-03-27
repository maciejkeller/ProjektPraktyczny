package external.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "MainData")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "temperature", nullable = false, table = "MainData")
    private Integer temperature;

    @Column(name = "pressure", nullable = false, table = "MainData")
    private Integer pressure;

    @Column(name = "humidity", nullable = false, table = "MainData")
    private Integer humidity;

    @Column(name = "windDirection", nullable = false, table = "MainData")
    private String windDirection;

    @Column(name = "windVelocity", nullable = false, table = "MainData")
    private Integer windVelocity;

   @ManyToOne
    @JoinColumn(name = "city")
    private City city;
}
