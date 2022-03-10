package models;


import javax.persistence.*;


@Entity // A anotação @Entity indica que a classe é mapeada para uma tabela (armazenar)
@Table(name = "cliente") // aqui eu especifico o nome da tabela no banco

public class Cliente {

    @Id // mostra que o atributo é uma PK
    @Column(name = "id")  // mapeio o atributo "numero" para a especificação da coluna "numero" na tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Indico que o valor é gerado e gerenciado pelo BD ( e o identity torna isso indepentende da implementação)
    private int id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "logradouro")
    private String logradouroo;

    @Column(name = "num_res")
    private int num_res;

    @Column(name = "andar")
    private Integer andar;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cep")
    private String cep;



}

