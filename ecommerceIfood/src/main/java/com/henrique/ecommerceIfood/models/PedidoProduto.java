package com.henrique.ecommerceIfood.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "pedido_produto")

public class PedidoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "desconto")
    private Double Desconto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco_unit")
    private Double preco_unit;

    @Column(name = "preco_total")
    private Double preco_total;

    @ManyToOne
    @JsonIgnoreProperties()
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDesconto() {
        return Desconto;
    }

    public void setDesconto(Double desconto) {
        Desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco_unit() {
        return preco_unit;
    }

    public void setPreco_unit(Double preco_unit) {
        this.preco_unit = preco_unit;
    }

    public Double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(Double preco_total) {
        this.preco_total = preco_total;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
