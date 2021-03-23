package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "MainData")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "maindata.id")
    private Integer id;

    private Integer temperature;
    private Integer pressure;
    private Integer humidity;
    private String windDirection;
    private Integer windVelocity;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "city.id")
    private City city;
}
