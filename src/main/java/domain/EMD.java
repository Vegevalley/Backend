package domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="emd")
public class EMD {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name="EMD_NAME")
    private String emdName;

    @OneToMany(mappedBy = "emd")
    private List<VegeContent> vegeContentlist;
}
