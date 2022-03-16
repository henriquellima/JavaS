package com.henrique.ecommerceIfood.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "produto")

public class Produto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "qtd_estoque")
    private Integer qtdEstoque;

    @Column(name = "preco")
    private Integer preco;

    @Column(name = "link_foto", length = 300)
    private String linkFoto;

    @ManyToOne   // relacao n:n
    @JsonIgnoreProperties("produtosList")
    @JoinColumn(name = "departamento_id")  // especificaçao da fk do modelo, nesse caso "Departamento"
    private Departamento departamento;

    public Produto(){
    }

    public Produto(Integer id, String nome, String descricao, Integer qtdEstoque, Integer preco, String linkFoto,
                   Integer idDepto, String nomeDepto, Integer andarDepto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.linkFoto = linkFoto;
        this.departamento = new Departamento();
        this.departamento.setId(idDepto);
        this.departamento.setNome(nomeDepto);
        this.departamento.setAndar(andarDepto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Integer getPreco() {
        return preco;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLink_foto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
