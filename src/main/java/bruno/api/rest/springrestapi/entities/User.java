package bruno.api.rest.springrestapi.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String name;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Phone> phones;

}
