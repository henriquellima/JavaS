package models;

import javax.persistence.*;

@Entity
@Table(name =  "produto")

public class produto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "qtd_estoque", columnDefinition = "TEXT")
    private Integer qtdEstoque;

    @Column(name = "preco", columnDefinition = "INT")
    private String preco;


    private int departamento;
}
