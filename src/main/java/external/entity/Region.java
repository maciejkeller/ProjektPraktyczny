package external.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Entity(name = "Region")
@Data

@Table(name = "Region")
public class Region {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", table = "Region")
    private int id;

    @Column(name = "region_name", nullable = false, table = "Region")
    private String regionName;

    //mappedBy = "id" to nazwa kolumny wskazywanej przez klucz obcy
    @OneToMany(mappedBy = "id")

    private List<Country> countries;


}