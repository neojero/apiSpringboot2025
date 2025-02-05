package fr.pompey.cda23016.apiprojet.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Person")
public class Person {

    // cle primaire
    @Id
    // auto-increment type=Identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // pas nécessaire mais je lie mon attribut d'objet avec la colonne de ma table en BDD
    @Column(name="id")
    private Integer id;

    // pas nécessaire mais je lie mon attribut d'objet avec la colonne de ma table en BDD
    @Column(name="firstname")
    private String firstName;

    // pas nécessaire mais je lie mon attribut d'objet avec la colonne de ma table en BDD
    @Column(name="lastname")
    private String lastName;

}
