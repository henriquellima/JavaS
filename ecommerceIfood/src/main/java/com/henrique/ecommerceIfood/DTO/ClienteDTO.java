package com.henrique.ecommerceIfood.DTO;

import com.henrique.ecommerceIfood.models.Cliente;

public class ClienteDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;


    public ClienteDTO(Integer id, String nome, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public ClienteDTO(Cliente cli) {
        this.id = cli.getId();
        this.nome = cli.getNome();
        this.cpf = cli.getCpf();
        this.email = cli.getEmail();
        this.telefone = cli.getTelefone();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
}
