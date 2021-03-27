package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private String localizationName;
    private String localizationLatitude;
    private String localizationLongtitude;
    private String localizationCountry;
    private String localizationRegion;


}
