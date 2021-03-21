package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "MainData")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer temperature;
    private Integer pressure;
    private Integer humidity;
    private String windDirection;
    private Integer windVelocity;
    private Localization city;
}
