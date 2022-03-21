package com.henrique.ecommerceIfood.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email", length = 60, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, unique = false, columnDefinition = "TEXT")
    private String senha;

    @Column(name = "nome", length = 100, nullable = false, unique = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name="telefone",length = 20, nullable = false, unique = true)
    private String telefone;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario")
    private List<Pedido> pedidosList;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("usuario")
    private List<Endereco> enderecosList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_permissao",
    joinColumns = {
            @JoinColumn(name = "usuario_id", referencedColumnName = "id",
            nullable = false, updatable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "permissao_id", referencedColumnName = "id",
            nullable = false, updatable = false)
    })
    private Set<Permissao> permissaoList;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public List<Pedido> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedido> pedidosList) {
        this.pedidosList = pedidosList;
    }

    public List<Endereco> getEnderecosList() {
        return enderecosList;
    }

    public void setEnderecosList(List<Endereco> enderecosList) {
        this.enderecosList = enderecosList;
    }

    public Set<Permissao> getPermissaoList() {
        return permissaoList;
    }

    public void setPermissaoList(Set<Permissao> permissaoList) {
        this.permissaoList = permissaoList;
    }
}
