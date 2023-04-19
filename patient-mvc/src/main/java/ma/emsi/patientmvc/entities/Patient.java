package ma.emsi.patientmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



//pour utiliser entity JPA
@Entity
// generer les getters et setters et les constructeurs
// jpa needs a constructor without parameter public
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private Date dateNaissance ;
// notation pour garder la date en format DATE
    @Temporal(TemporalType.DATE)
    private boolean malade;
    private int score ;


}
