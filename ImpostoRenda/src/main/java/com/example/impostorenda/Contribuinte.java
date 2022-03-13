package com.example.impostorenda;

public abstract class Contribuinte {
    protected String nome;
    protected int id;
    protected Endereco endereco;

    public Contribuinte(String nome, int id, Endereco endereco) {
        this.nome = nome;
        this.id = id;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public abstract double calcularImposto();
}
