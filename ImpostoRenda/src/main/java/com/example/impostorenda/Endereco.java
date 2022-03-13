package com.example.impostorenda;

public class Endereco {
    private String cep;
    private String numero;
    private String Complemento;

    public Endereco(String cep, String numero, String complemento) {
        this.cep = cep;
        this.numero = numero;
        Complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }
}
