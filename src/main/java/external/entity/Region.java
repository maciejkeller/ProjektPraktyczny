package external.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Region")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", table = "Region")
    private Integer id;

    @Column(name = "region_name", nullable = false, table = "Region")
    private String regionName;

    //mappedBy = "id" to nazwa kolumny wskazywanej przez klucz obcy
    @OneToMany(mappedBy = "id")
    private List<Country> countries;

}

