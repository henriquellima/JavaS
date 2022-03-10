package models;

import javax.persistence.*;


@Entity
@Table(name = "departamento")

public class Departamento {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "andar")
    private String andar;
}

