package com.henrique.ecommerceIfood.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "pedido")

public class Pedido {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "data", length = 8)
    private Date data;

    @Column(name = "valor_bruto")
    private double valor_bruto;

    @Column(name = "desconto")
    private double desconto;

    @Column(name = "valor_total")
    private double valor_total;

    @ManyToOne
    @JsonIgnoreProperties("pedidosList")
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("pedido")
    private List<PedidoProduto> produtosList;

    public List<PedidoProduto> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<PedidoProduto> produtosList) {
        this.produtosList = produtosList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor_bruto() {
        return valor_bruto;
    }

    public void setValor_bruto(double valor_bruto) {
        this.valor_bruto = valor_bruto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

}
