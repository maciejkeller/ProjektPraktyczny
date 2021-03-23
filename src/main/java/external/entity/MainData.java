package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "MainData")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainData {
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
